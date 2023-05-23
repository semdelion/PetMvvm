package com.semdelion.data.services.interfaces

import com.semdelion.data.services.models.NewsResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NewsServices {
    @GET("1/news")
    fun getNews(@Query("language") language: String = "ru"): Call<NewsResult>
}