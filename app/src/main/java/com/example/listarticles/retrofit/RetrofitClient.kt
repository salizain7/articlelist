package com.example.listarticles.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api : ArticleApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/svc/mostpopular/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ArticleApi::class.java)
    }
}


