package com.example.chucknorrisapi

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chucknorrisapi.adapters.CustomAdapter
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity(), ItemClickPosition {
    lateinit var txvJoke: TextView
    val viewModel : ViewModelJokes by viewModels()
    val listItemMenu = arrayListOf("Choose Category", "Show All Favorite Jokes")
    val starForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
    {
        result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK){
            val tvTitleCategogy : TextView = findViewById(R.id.txv_title_category)
            val chosenCategory = result.data?.getStringExtra("category")
            tvTitleCategogy.text = getString(R.string.title_card, chosenCategory)
            viewModel.getJokeByCategory(chosenCategory)
        }
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txvJoke = findViewById(R.id.txv_joke)
        val recycler : RecyclerView = findViewById(R.id.rv_jokes)
        val layoutManager = LinearLayoutManager(this)
        recycler.layoutManager = layoutManager
        recycler.adapter = CustomAdapter(this, listItemMenu)
        val tfEditText : TextInputEditText = findViewById(R.id.tf_editText)
        viewModel.liveDataSearchResponse.observe(this){
            val intent = Intent(this, ShowJokeCardsActivity::class.java)
            intent.putExtra("title", getString(R.string.tf_search))
            startActivity(intent)
        }
        val searchJokes : TextInputLayout = findViewById(R.id.tf_opjokes)
        searchJokes.setEndIconOnClickListener {
            viewModel.getSearchJoke(tfEditText.text.toString())
        }


        val tvCategoryCard : TextView = findViewById(R.id.txv_title_category)
        tvCategoryCard.visibility = View.VISIBLE
        val btnLoadAnotherJoke : Button = findViewById(R.id.load_jokes)
        btnLoadAnotherJoke.visibility = View.VISIBLE
        btnLoadAnotherJoke.setOnClickListener {
            viewModel.getRandomJoke()
        }
        viewModel.liveData.observe(this){
            txvJoke.text = it.value
        }
    }

    override fun onClickChooseCategory(chooseCategory: String) {
        if (listItemMenu[0] == chooseCategory){
            starForResult.launch(Intent(this,  CategoryActivity::class.java))
        } else if (listItemMenu[1] == chooseCategory){
            val intent = Intent(this, ShowJokeCardsActivity::class.java)
            intent.putExtra("title", getString(R.string.all_favorite_jokes))
            startActivity(intent)
        }
}}