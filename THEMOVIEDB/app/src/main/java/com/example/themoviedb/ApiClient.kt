package com.example.themoviedb

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("/3/movie/popular?api_key=f93f2306dd57a8d5c1932faa0774cd16")
    fun getTrending0( ) : Call<ResponseTrending>

    @GET("/3/movie/top_rated?api_key=f93f2306dd57a8d5c1932faa0774cd16")
    fun getTrending1( ) : Call<ResponseTrending>

    @GET("/3/movie/upcoming?api_key=f93f2306dd57a8d5c1932faa0774cd16")
    fun getTrending2( ) : Call<ResponseTrending>

    @GET("/3/movie/now_playing?api_key=f93f2306dd57a8d5c1932faa0774cd16")
    fun getTrending3( ) : Call<ResponseTrending>



    @GET("/3/search/movie")
    fun seach(@Query("api_key") key: String,
                  @Query("query") query: String) : Call<ResponseTrending>

}