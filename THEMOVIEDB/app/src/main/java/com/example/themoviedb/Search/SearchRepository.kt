package com.example.themoviedb.Search

import com.example.themoviedb.retrofit.ApiClient
import com.example.themoviedb.retrofit.Network12
import com.example.themoviedb.responce.Response
import retrofit2.Callback

class SearchRepository (private val callback: Callback<Response>) {
    fun getListofSearch(query : String) {
        val apiClient = Network12.getInstance().create(ApiClient::class.java)
        val call = apiClient.seach("f93f2306dd57a8d5c1932faa0774cd16", query)
        call.enqueue(callback)
    }
}