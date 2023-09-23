package com.frhatieh.articlesapp.data.repository

import com.frhatieh.articlesapp.domain.model.Response
import com.frhatieh.articlesapp.domain.model.User
import com.frhatieh.articlesapp.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth,
    private val dbUsers: DatabaseReference
) : AuthRepository {
    override val currentUser: FirebaseUser? = auth.currentUser

    override suspend fun loginIn(email: String, password: String): Response<Boolean> =
        try {
            auth.signInWithEmailAndPassword(email, password).await()
            Response.Success(true)
        } catch (e: Exception) {
            Response.Failure(e)
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
        val user = User(fullName, phoneNumber, nationalId, dateOfBirth)
        if (uid != null) {
            dbUsers.child(uid).setValue(user).await()
            Response.Success(true)
        } else {
            Response.Failure(java.lang.Exception())
        }
    } catch (e: Exception) {
        Response.Failure(e)
    }

}