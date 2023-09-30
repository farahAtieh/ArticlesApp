package com.frhatieh.articlesapp.data.model

import com.google.gson.annotations.SerializedName

data class PopularArticlesResponse(
    @SerializedName("num_results")
    val numOfResults: Int,
    @SerializedName("results")
    val results: List<ArticleResponse>
)