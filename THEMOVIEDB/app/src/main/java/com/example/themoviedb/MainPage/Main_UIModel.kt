package com.example.themoviedb.MainPage

import com.example.themoviedb.responce.ResultsItem

sealed class Main_UIModel {

    data class Success(val dataModelList: List<ResultsItem>) : Main_UIModel()

    data class Failure(val error: String) : Main_UIModel()
}