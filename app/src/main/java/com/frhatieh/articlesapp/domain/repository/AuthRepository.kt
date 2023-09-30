package com.frhatieh.articlesapp.domain.repository

import com.frhatieh.articlesapp.domain.model.Response
import com.frhatieh.articlesapp.domain.model.User
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await

interface AuthRepository {
    val currentUser: FirebaseUser?

    suspend fun loginIn(email: String, password: String): Response<Boolean>

    suspend fun logout(): Response<Boolean>
    suspend fun register(email: String,
                         password: String,
                         nationalId: String,
                         phoneNumber: String,
                         fullName: String,
                         dataOfBirth: String): Response<Boolean>

    suspend fun register(email: String, password: String): Response<Boolean>

    suspend fun saveUser(
        uid: String?,
        fullName: String,
        nationalId: String,
        phoneNumber: String,
        dateOfBirth: String
    ): Response<Boolean>

    suspend fun getUser(): Response<User>

    suspend fun removeUser()
}