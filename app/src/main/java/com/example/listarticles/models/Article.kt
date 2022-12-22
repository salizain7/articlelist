package com.example.listarticles.models

data class Article(
    val url : String,
    val id : Long,
    val published_date : String,
    val title : String,
    val abstract : String,
    var media : List<Media>
)