package com.example.listarticles.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listarticles.`interface`.IArticleItemClickListener
import com.example.listarticles.adapters.ArticleListAdapter
import com.example.listarticles.databinding.ActivityMainBinding
import com.example.listarticles.models.Article
import com.example.listarticles.viewmodels.ArticleViewModel

class MainActivity : AppCompatActivity() , IArticleItemClickListener{

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: ArticleViewModel
    private lateinit var articleListAdapter : ArticleListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializeRv()
        viewModel = ViewModelProvider(this)[ArticleViewModel::class.java]
        viewModel.getFavoriteArticles()
        viewModel.observeArticleLiveData().observe(this, Observer { articleList ->
        articleListAdapter.setArticleList(articleList)
        articleListAdapter.setItemClickListenr(this)
        binding.pBar.visibility = View.GONE
        })
    }

    private fun initializeRv() {
        articleListAdapter = ArticleListAdapter()
        binding.rvArticles.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = articleListAdapter

        }

    }

    override fun onItemClick(position: Int, article: Article?) {
        if(!article!!.url.isEmpty() && article.url!=null){
            val intent = Intent(this@MainActivity, ArticleDetailActivity::class.java)
            intent.putExtra("url",article!!.url!!)
            startActivity(intent)
        }

    }
}