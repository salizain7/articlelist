package com.example.listarticles.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.listarticles.models.AllArticlesResponse
import com.example.listarticles.models.Article
import com.example.listarticles.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArticleViewModel : ViewModel() {

    private var articleLiveData = MutableLiveData<List<Article>>()
    fun getFavoriteArticles() {
        RetrofitInstance.api.getFavoriteArticles("GSIO1lUjiw3zfk3X0Rs0yk0ZfLej0srU").enqueue(object  : Callback<AllArticlesResponse> {
            override fun onResponse(call: Call<AllArticlesResponse>, response: Response<AllArticlesResponse>) {
                if (response.body()!=null){
                    articleLiveData.value = response.body()!!.results
                }
                else{
                    return
                }
            }
            override fun onFailure(call: Call<AllArticlesResponse>, t: Throwable) {
                Log.d("-----ERROR------",t.message.toString())
            }
        })
    }
    fun observeArticleLiveData() : LiveData<List<Article>> {
        return articleLiveData
    }
}
