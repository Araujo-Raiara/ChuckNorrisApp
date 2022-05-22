package com.example.chucknorrisapi.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chucknorrisapi.Jokes
import com.example.chucknorrisapi.R
import com.example.chucknorrisapi.ShowJokeCardsActivity

class ShowJokesAdapter(val jokesList: ArrayList<Jokes>) : RecyclerView.Adapter<ShowJokesAdapter.Holder>() {
    class  Holder (view: View) : RecyclerView.ViewHolder(view){
        val showJoke : TextView

        init {
            showJoke = view.findViewById(R.id.txv_joke)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_main, parent, false)

        return Holder(view)

    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.showJoke.text = jokesList[position].value
    }

    override fun getItemCount(): Int {
        return jokesList.size
    }


}