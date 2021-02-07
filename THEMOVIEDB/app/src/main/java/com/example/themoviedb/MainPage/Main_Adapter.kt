package com.example.themoviedb.MainPage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviedb.R
import com.example.themoviedb.responce.ResultsItem

class Main_Adapter(private var dataModelList: List<ResultsItem>, var mainListner: Main_Listner) :
    RecyclerView.Adapter<Main_ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Main_ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return Main_ViewHolder(view,mainListner)
    }

    override fun onBindViewHolder(holder: Main_ViewHolder, position: Int) {
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