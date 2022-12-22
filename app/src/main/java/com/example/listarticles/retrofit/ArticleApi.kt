package com.example.listarticles.retrofit

import com.example.listarticles.models.AllArticlesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleApi {

    @GET("v2/viewed/7.json?")
    fun getFavoriteArticles(@Query("api-key") apiKey : String) : Call<AllArticlesResponse>

}