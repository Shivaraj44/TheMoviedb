package com.example.themoviedb

import retrofit2.Callback

class UserRepository(private val callback: Callback<ResponseTrending>) {

    fun getListOfModel0() {
        val apiClient =Network12.getInstance().create(ApiClient::class.java)
        val call = apiClient.getTrending0()

        call.enqueue(callback)
    }
    fun getListOfModel1() {
        val apiClient =Network12.getInstance().create(ApiClient::class.java)
        val call = apiClient.getTrending1()

        call.enqueue(callback)
    }
    fun getListOfModel2() {
        val apiClient =Network12.getInstance().create(ApiClient::class.java)
        val call = apiClient.getTrending2()

        call.enqueue(callback)
    }

    fun getListOfModel3() {
        val apiClient =Network12.getInstance().create(ApiClient::class.java)
        val call = apiClient.getTrending2()

        call.enqueue(callback)
    }
}