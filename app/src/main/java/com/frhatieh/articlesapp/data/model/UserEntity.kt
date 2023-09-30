package com.frhatieh.articlesapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserTable")
data class UserEntity (
    @PrimaryKey
    val uid: String,
    val email: String,
    val password: String,
    val fullName: String,
    val nationalId: String,
    val phoneNumber: String,
    val dateOfBirth: String
)