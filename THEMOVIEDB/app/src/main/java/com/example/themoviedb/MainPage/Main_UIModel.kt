package com.example.themoviedb.MainPage

import com.example.themoviedb.responce.ResultsItem
/**
Model class to do the Success and Failure about the Api Retrofit

 */
sealed class Main_UIModel {

    data class Success(val dataModelList: List<ResultsItem>) : Main_UIModel()

    data class Failure(val error: String) : Main_UIModel()
}