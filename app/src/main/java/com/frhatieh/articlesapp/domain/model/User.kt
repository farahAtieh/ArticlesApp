package com.frhatieh.articlesapp.domain.model

data class User(
    val fullName: String,
    val email: String,
    val nationalId: String,
    val phoneNumber: String,
    val dateOfBirth: String
)
