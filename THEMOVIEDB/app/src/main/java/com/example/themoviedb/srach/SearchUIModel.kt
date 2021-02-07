package com.example.themoviedb.srach

import com.example.themoviedb.ResultsItem

sealed class SearchUIModel {
    data class Success(val SearchList: List<ResultsItem>) : SearchUIModel()
    data class Failure(val  error: String) : SearchUIModel()
}