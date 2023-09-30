package com.frhatieh.articlesapp.data.datasource

import com.frhatieh.articlesapp.data.model.PopularArticlesResponse
import com.frhatieh.articlesapp.data.network.ArticlesEndPoint
import java.io.IOException
import javax.inject.Inject
import kotlin.random.Random

class RemoteDataSource @Inject constructor(
    private val articlesEndPoint: ArticlesEndPoint
) {

    suspend fun fetchPopularViewedArticles(): Result<PopularArticlesResponse> {
        val random = getRandomNumber().toString()
        val response = articlesEndPoint.getPopularViewedArticles(random)
        if(response.isSuccessful){
            return response.body()?.let {
                Result.success(it)
            } ?: Result.failure(IOException("No data received."))
        }

        val error = response.errorBody()
        return Result.failure(IOException(error.toString()))
    }

    private fun getRandomNumber(): Int {
        return when (Random.nextInt(3)) {
            0 -> 1
            1 -> 7
            else -> 30
        }
    }
}