package com.example.themoviedb.Search

import com.example.themoviedb.responce.ResultsItem

sealed class SearchUIModel {
    data class Success(val SearchList: List<ResultsItem>) : SearchUIModel()
    data class Failure(val  error: String) : SearchUIModel()
}