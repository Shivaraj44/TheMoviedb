package com.example.themoviedb.retrofit

import com.example.themoviedb.responce.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("/3/movie/popular?api_key=f93f2306dd57a8d5c1932faa0774cd16")
    fun getTrending0( ) : Call<Response>

    @GET("/3/movie/top_rated?api_key=f93f2306dd57a8d5c1932faa0774cd16")
    fun getTrending1( ) : Call<Response>

    @GET("/3/movie/upcoming?api_key=f93f2306dd57a8d5c1932faa0774cd16")
    fun getTrending2( ) : Call<Response>

    @GET("/3/movie/now_playing?api_key=f93f2306dd57a8d5c1932faa0774cd16")
    fun getTrending3( ) : Call<Response>



    @GET("/3/search/movie")
    fun seach(@Query("api_key") key: String,
                  @Query("query") query: String) : Call<Response>

}