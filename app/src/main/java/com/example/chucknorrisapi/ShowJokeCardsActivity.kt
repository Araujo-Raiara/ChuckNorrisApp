package com.example.chucknorrisapi

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chucknorrisapi.adapters.ShowJokesAdapter


class ShowJokeCardsActivity : AppCompatActivity(){
    val viewModel : ViewModelJokes by viewModels()

    val joke1 = Jokes(categories = listOf(), created_at = "2020-01-05 13:42:28.420821",
        icon_url = "https://assets.chucknorris.host/img/avatar/chuck-norris.png",
        id = "nJoj_ZNRR525DfuwSMhGqQ", updated_at = "2020-01-05 13:42:28.420821",
        url = "https://api.chucknorris.io/jokes/nJoj_ZNRR525DfuwSMhGqQ",
        value = "Chuck Norris and his toothbrush can take on a guy wielding a crowbar. And win.")

    val joke2 = Jokes(categories = listOf("science"), created_at = "2020-01-05 13:42:19.576875",
        icon_url = "https://assets.chucknorris.host/img/avatar/chuck-norris.png",
        id = "rgxflbh9qx-i51rt3o3-xq", updated_at = "2020-01-05 13:42:19.576875",
        url = "https://api.chucknorris.io/jokes/rgxflbh9qx-i51rt3o3-xq",
        value = "Chuck Norris describes human beings as \"a sociable holder for blood and guts\".")

    val joke3 = Jokes(categories = listOf(), created_at = "2020-01-05 13:42:20.262289",
        icon_url = "https://assets.chucknorris.host/img/avatar/chuck-norris.png",
        id = "MLfWSdKJQOa2FCxD_KAsFA", updated_at = "2020-01-05 13:42:20.262289",
        url = "https://api.chucknorris.io/jokes/MLfWSdKJQOa2FCxD_KAsFA",
        value ="Some kids piss their name in the snow. Chuck Norris can piss his name into concrete.")

    val jokesList : ArrayList<Jokes> = arrayListOf(joke1, joke2, joke3)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_joke_cards)
        val tv_all_jokes : TextView = findViewById(R.id.tvx_all_jokes)
        tv_all_jokes.text = intent.getStringExtra("title")
        val rvJokes : RecyclerView = findViewById(R.id.rv_all_jokes)
        val layoutManager =  LinearLayoutManager(this)
        rvJokes.layoutManager = layoutManager
        rvJokes.adapter = ShowJokesAdapter(jokesList)
    }



}