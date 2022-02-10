package com.example.thedailynews

import retrofit2.http.GET
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Query

const val BASE_URL = "https://newsapi.org/v2/"
interface ApiInterface {

    @GET("top-headlines")
    fun getNews(
        @Query("country") country: String,
        @Query("pageSize") pagesize: Int,
        @Query("apiKey") apikey:String): Call<MainNews>

    @GET("top-headlines")
    fun getCategoryNews(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("pageSize") pagesize: Int,
        @Query("apiKey") apikey:String): Call<MainNews>
}

object NewsService{
    val newsInstance: ApiInterface

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retrofit.create(ApiInterface::class.java)
    }
}