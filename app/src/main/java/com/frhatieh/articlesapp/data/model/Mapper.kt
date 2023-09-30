package com.frhatieh.articlesapp.data.model

import com.frhatieh.articlesapp.domain.model.User

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

fun UserEntity.toUser() =
    User(
        email = email,
        fullName = fullName,
        nationalId = nationalId,
        dateOfBirth = dateOfBirth,
        phoneNumber = phoneNumber
    )
