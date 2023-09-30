package com.frhatieh.articlesapp.data.model

data class Article(
    val id: Long,
    val title: String,
    val briefDescription: String,
    val url: String,
    val publishedDate: String,
    val imageUrl: String
)