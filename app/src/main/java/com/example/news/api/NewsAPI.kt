package com.example.news.api

import com.example.news.models.NewsResponse
import com.example.news.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.Locale.IsoCountryCode

interface  NewsAPI {
    @GET("v2/top-headlines")
     suspend fun getHeadLines(
        @Query("country")
        countryCode: String = "us",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
     ):Response<NewsResponse>

     @GET("v2/everything")
     suspend fun searchForNews(
         @Query("q")
         seachQuery: String,
         @Query("page")
         pageNumber: Int = 1,
         @Query("apiKey")
         apiKey: String = API_KEY
     ):Response<NewsResponse>

}