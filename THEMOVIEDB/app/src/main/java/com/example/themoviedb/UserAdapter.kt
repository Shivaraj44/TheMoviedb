package com.example.themoviedb

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private var dataModelList: List<ResultsItem>,var listner:Listner) :
    RecyclerView.Adapter<UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return UserViewHolder(view,listner)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val dataModel = dataModelList[position]
        holder.setData(dataModel)
    }

    override fun getItemCount(): Int {
        return dataModelList.size
    }

    fun updateList(modelList: List<ResultsItem>) {
        dataModelList = modelList
        notifyDataSetChanged()
    }

}