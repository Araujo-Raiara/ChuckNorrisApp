package com.example.chucknorrisapi.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chucknorrisapi.ItemClickPosition
import com.example.chucknorrisapi.R
import com.google.android.material.button.MaterialButton

class CustomAdapter(val clickPosition: ItemClickPosition, val listItemMenu: List<String>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val btnChooseCategory : MaterialButton = view.findViewById(R.id.btn_choose_category)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.btn_choose_category, parent, false)

        return  ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.btnChooseCategory.text = listItemMenu[position]
        holder.btnChooseCategory.setOnClickListener {
            clickPosition.onClickChooseCategory(chooseCategory = listItemMenu[position])
        }
    }

    override fun getItemCount(): Int {
        return listItemMenu.size


    }
}