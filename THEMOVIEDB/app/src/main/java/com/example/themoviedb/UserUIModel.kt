package com.example.themoviedb

sealed class UserUIModel {

    data class Success(val dataModelList: List<ResultsItem>) : UserUIModel()

    data class Failure(val error: String) : UserUIModel()
}