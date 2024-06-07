package com.jt.tribalcategorias.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jt.tribalcategorias.R

class CategoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val titleCategory: TextView = itemView.findViewById(R.id.category_title)

    fun bind(category: String){
        titleCategory.text = category
    }

}