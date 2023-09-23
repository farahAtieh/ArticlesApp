package com.frhatieh.articlesapp.domain.repository

import com.frhatieh.articlesapp.domain.model.Response
import com.google.firebase.auth.FirebaseUser

interface AuthRepository {
    val currentUser: FirebaseUser?

    suspend fun loginIn(email: String, password: String): Response<Boolean>

    suspend fun register(email: String, password: String): Response<Boolean>

    suspend fun saveUser(
        uid: String?,
        fullName: String,
        nationalId: String,
        phoneNumber: String,
        dateOfBirth: String
    ): Response<Boolean>
}