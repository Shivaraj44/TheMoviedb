package com.example.themoviedb.Search

import com.example.themoviedb.responce.ResultsItem

interface ItemClickListener {
    fun onItemClicked(position:Int,resultsItem: ResultsItem)
}