package com.frhatieh.articlesapp.data.model

import com.google.gson.annotations.SerializedName

data class ArticleResponse(
    @SerializedName("id")
    val id: Long,
    @SerializedName("title")
    val title: String,
    @SerializedName("abstract")
    val briefDescription: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("published_date")
    val publishedDate: String,
    @SerializedName("media")
    val media: List<Media>?,
){
    data class Media(
        @SerializedName("type")
        val type: String,
        @SerializedName("media-metadata")
        val metadata: List<MediaMetadata>
    ){
        data class MediaMetadata(
            @SerializedName("url")
            val url: String,
            @SerializedName("height")
            val height: Int,
            @SerializedName("width")
            val width: Int
        )
    }

    fun getImageUrl(): String {
        if (media.isNullOrEmpty()) return ""
        val urls = media[0].metadata.filter {
            it.height == 140 && it.width == 210
        }
        return if(urls.isNotEmpty()) urls[0].url else ""
    }
}

