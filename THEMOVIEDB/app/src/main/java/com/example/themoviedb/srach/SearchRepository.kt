package com.example.themoviedb.srach

import android.net.Network
import com.example.themoviedb.ApiClient
import com.example.themoviedb.Network12
import com.example.themoviedb.ResponseTrending
import retrofit2.Callback

class SearchRepository (private val callback: Callback<ResponseTrending>) {
    fun getListofSearch(query : String) {
        val apiClient = Network12.getInstance().create(ApiClient::class.java)
        val call = apiClient.seach("f93f2306dd57a8d5c1932faa0774cd16", query)
        call.enqueue(callback)
    }
}