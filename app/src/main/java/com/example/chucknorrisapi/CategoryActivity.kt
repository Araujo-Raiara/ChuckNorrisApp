package com.example.chucknorrisapi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chucknorrisapi.adapters.CustomAdapter

class CategoryActivity : AppCompatActivity(), ItemClickPosition {
    val viewModel : ViewModelJokes by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)
        val recyclerCategories: RecyclerView = findViewById(R.id.rv_categories)
        val layoutManager = LinearLayoutManager(this)
        recyclerCategories.layoutManager = layoutManager
        viewModel.getCategories()
        viewModel.liveDataCategories.observe(this){
            recyclerCategories.adapter = CustomAdapter(this, it.categories )
        }
    }
    override fun onClickChooseCategory(chooseCategory: String) {
        val data = Intent()
        data.putExtra("category", chooseCategory)
        setResult(RESULT_OK, data)
        finish()
    }


}