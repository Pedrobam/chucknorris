package com.example.chucknorris.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chucknorris.R
import kotlinx.android.synthetic.main.item_category.view.*

class CategoryAdapter(
    private val categoryList: List<String>,
    private val onClick: (String) -> Unit = {}
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categoryList[position]
        holder.bindView(category)
        holder.itemView.setOnClickListener {
            onClick(category)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(category: String) {
            with(itemView) {
                title.text = category
            }
        }
    }
}