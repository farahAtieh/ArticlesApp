package com.frhatieh.articlesapp.domain.repository

import com.frhatieh.articlesapp.data.model.Article
import kotlinx.coroutines.flow.Flow

interface ArticlesRepository {

    fun getPopularViewedArticles(): Flow<List<Article>>

    fun fetchPopularViewedArticles(): Flow<Result<List<Article>>>

    suspend fun clearAllArticles()
}