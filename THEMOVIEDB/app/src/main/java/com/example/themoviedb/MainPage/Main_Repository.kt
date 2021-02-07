package com.example.themoviedb.MainPage

import com.example.themoviedb.responce.Response
import com.example.themoviedb.retrofit.ApiClient
import com.example.themoviedb.retrofit.Network12
import retrofit2.Callback

class Main_Repository(private val callback: Callback<Response>) {

    fun getListOfModel0() {
        val apiClient = Network12.getInstance().create(ApiClient::class.java)
        val call = apiClient.getTrending0()

        call.enqueue(callback)
    }
    fun getListOfModel1() {
        val apiClient = Network12.getInstance().create(ApiClient::class.java)
        val call = apiClient.getTrending1()

        call.enqueue(callback)
    }
    fun getListOfModel2() {
        val apiClient = Network12.getInstance().create(ApiClient::class.java)
        val call = apiClient.getTrending2()

        call.enqueue(callback)
    }

    fun getListOfModel3() {
        val apiClient = Network12.getInstance().create(ApiClient::class.java)
        val call = apiClient.getTrending2()

        call.enqueue(callback)
    }
}