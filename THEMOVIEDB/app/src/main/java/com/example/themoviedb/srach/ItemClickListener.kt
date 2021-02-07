package com.example.themoviedb.srach

import com.example.themoviedb.ResultsItem

interface ItemClickListener {
    fun onItemClicked(position:Int,resultsItem: ResultsItem)
}