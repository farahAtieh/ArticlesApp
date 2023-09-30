package com.frhatieh.articlesapp.data.repository

import com.frhatieh.articlesapp.data.datasource.LocalDataSource
import com.frhatieh.articlesapp.data.datasource.RemoteDataSource
import com.frhatieh.articlesapp.data.model.toArticle
import com.frhatieh.articlesapp.data.model.toArticleEntity
import com.frhatieh.articlesapp.domain.repository.ArticlesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class ArticlesRepositoryImpl(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : ArticlesRepository {

    override fun getPopularViewedArticles() = localDataSource.getAllArticles()
        .map { localData ->
            localData.map {
                it.toArticle()
            }
        }

    override fun fetchPopularViewedArticles() =
        flow {
            try {
                val articlesResponse = remoteDataSource.fetchPopularViewedArticles()
                if (articlesResponse.isSuccess) {
                    val results = articlesResponse.getOrThrow().results
                    localDataSource.insertAllArticle(results.map {
                        it.toArticleEntity()
                    })
                    emit(Result.success(results.map { it.toArticle() }))
                }
            } catch (e: Exception) {
                emit(Result.failure(e))
            }

        }.flowOn(Dispatchers.IO)

    override suspend fun clearAllArticles() {
        withContext(Dispatchers.IO){
            localDataSource.clearAll()
        }
    }
}