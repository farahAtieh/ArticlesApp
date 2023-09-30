package com.frhatieh.articlesapp.data.network

import com.frhatieh.articlesapp.data.model.PopularArticlesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

private const val MOST_POPULAR_VIEWED_ARTICLE_PATH = "mostpopular/v2/viewed/{day}.json"

interface ArticlesEndPoint {
    @GET(MOST_POPULAR_VIEWED_ARTICLE_PATH)
    suspend fun getPopularViewedArticles(
         @Path("day") day: String,
    ): Response<PopularArticlesResponse>
}