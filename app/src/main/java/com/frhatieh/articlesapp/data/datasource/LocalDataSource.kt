package com.frhatieh.articlesapp.data.datasource

import com.frhatieh.articlesapp.data.database.dao.ArticlesDao
import com.frhatieh.articlesapp.data.model.ArticleEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalDataSource(
    private val articlesDao: ArticlesDao
) {

    fun getAllArticles() =
        articlesDao.getAllArticles()

    suspend fun insertArticle(article: ArticleEntity) =
        withContext(Dispatchers.IO){
            articlesDao.insertArticle(article)
        }

    suspend fun insertAllArticle(articles: List<ArticleEntity>) =
        withContext(Dispatchers.IO){
            articlesDao.insertAllArticles(articles)
        }

    suspend fun clearAll() =
        withContext(Dispatchers.IO){
            articlesDao.clearAll()
        }
}
