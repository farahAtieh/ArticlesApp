package com.frhatieh.articlesapp.data.model

fun ArticleEntity.toArticle() =
    Article(
        id = id,
        title = title,
        briefDescription = briefDescription,
        url = url,
        publishedDate = publishedDate,
        imageUrl = imageUrl,
    )

fun ArticleResponse.toArticleEntity() =
    ArticleEntity(
        id = id,
        title = title,
        briefDescription = briefDescription,
        url = url,
        publishedDate = publishedDate,
        imageUrl = getImageUrl()
    )

fun ArticleResponse.toArticle() =
    Article(
        id = id,
        title = title,
        briefDescription = briefDescription,
        url = url,
        publishedDate = publishedDate,
        imageUrl = getImageUrl()
    )