package com.frhatieh.articlesapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ArticleTable")
data class ArticleEntity(
    @PrimaryKey
    val id: Long,
    val title: String,
    val briefDescription: String,
    val url: String,
    val publishedDate: String,
    val imageUrl: String
)