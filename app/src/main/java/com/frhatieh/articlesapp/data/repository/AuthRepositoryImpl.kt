package com.frhatieh.articlesapp.data.repository

import com.frhatieh.articlesapp.data.datasource.LocalDataSource
import com.frhatieh.articlesapp.data.datasource.UserLocalDataSource
import com.frhatieh.articlesapp.data.model.UserEntity
import com.frhatieh.articlesapp.data.model.toUser
import com.frhatieh.articlesapp.domain.model.Response
import com.frhatieh.articlesapp.domain.model.User
import com.frhatieh.articlesapp.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth,
    private val dbUsers: DatabaseReference,
    private val localDataSource: UserLocalDataSource
) : AuthRepository {
    override val currentUser: FirebaseUser? = auth.currentUser

    override suspend fun loginIn(email: String, password: String): Response<Boolean> =
        try {
            auth.signInWithEmailAndPassword(email, password).await()
            Response.Success(true)
        } catch (e: Exception) {
            Response.Failure(e)
        }

    override suspend fun logout() =
        try {
            auth.signOut()
            Response.Success(true)
        } catch (e: Exception) {
            Response.Failure(e)
        }


    override suspend fun register(
        email: String,
        password: String,
        nationalId: String,
        phoneNumber: String,
        fullName: String,
        dataOfBirth: String
    ): Response<Boolean> {
        return withContext(Dispatchers.IO) {
            try {
                val authResult = auth.createUserWithEmailAndPassword(email, password).await()
                val userEntity = UserEntity(
                    authResult.user?.uid ?: "",
                    email = email,
                    password = password,
                    fullName = fullName,
                    nationalId = nationalId,
                    phoneNumber = phoneNumber,
                    dateOfBirth = dataOfBirth
                )
                localDataSource.saveUser(userEntity)
                Response.Success(true)
            } catch (e: Exception) {
                Response.Failure(e)
            }
        }
    }

    override suspend fun register(email: String, password: String): Response<Boolean> {
        return try {
            val authResult = auth.createUserWithEmailAndPassword(email, password).await()
            saveUser(authResult.user?.uid, "farah", "", "", "")
        } catch (e: Exception) {
            Response.Failure(e)
        }

    }

    override suspend fun saveUser(
        uid: String?,
        fullName: String,
        nationalId: String,
        phoneNumber: String,
        dateOfBirth: String
    ): Response<Boolean> = try {
        val user = User(fullName, "", phoneNumber, nationalId, dateOfBirth)
        if (uid != null) {
            dbUsers.child(uid).setValue(user).await()
            Response.Success(true)
        } else {
            Response.Failure(java.lang.Exception())
        }
    } catch (e: Exception) {
        Response.Failure(e)
    }

    override suspend fun getUser(): Response<User> =
        withContext(Dispatchers.IO) {
            try {
                val user = localDataSource.getUser(currentUser?.uid ?: "").toUser()
                Response.Success(user)
            } catch (e: Exception) {
                Response.Failure(e)
            }
        }

    override suspend fun removeUser() {
        withContext(Dispatchers.IO) {
            localDataSource.removeUser()
        }
    }
}