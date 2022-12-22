package com.example.listarticles.`interface`

import com.example.listarticles.models.Article

interface IArticleItemClickListener {
    fun onItemClick(position: Int, article: Article?)

}