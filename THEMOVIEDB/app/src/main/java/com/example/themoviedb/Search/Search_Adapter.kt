package com.example.themoviedb.Search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviedb.R
import com.example.themoviedb.responce.ResultsItem

class Search_Adapter (
    var searchList: List<ResultsItem>,
    var itemClickListener: ItemClickListener
) :
    RecyclerView.Adapter<Search_ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Search_ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.wishlist_item_select, parent, false)
        return Search_ViewHolder(view)
    }
    override fun onBindViewHolder(holder: Search_ViewHolder, position: Int) {
        val resultsItem = searchList[position]
        holder.setData(resultsItem, itemClickListener)
    }
    override fun getItemCount(): Int {
        return searchList.size
    }
    fun updateDataList(searchList: List<ResultsItem>) {
        this.searchList = searchList
        notifyDataSetChanged()
    }
}