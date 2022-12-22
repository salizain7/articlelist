package com.example.listarticles.activities

import android.app.Activity
import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import com.example.listarticles.R
import java.util.*


class ArticleDetailActivity : Activity() {

    private lateinit var webView: WebView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_article_detail)
        progressBar= findViewById(R.id.pBar)
    }

    override fun onResume() {
        super.onResume()

        if(intent.hasExtra("url")) {
            val intent = intent
            val url = intent.getStringExtra("url")

            webView = findViewById(R.id.webview)
            webView.settings.setJavaScriptEnabled(true)
            webView.settings.setSupportZoom(true)
            webView.loadUrl(url!!)
            webView.webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView, url: String) {
                    progressBar.visibility = View.GONE
                }
            }
        }

    }
}