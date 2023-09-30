package com.frhatieh.articlesapp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.frhatieh.articlesapp.data.model.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM UserTable WHERE uid = :uid")
    fun getUser(uid: String): UserEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(userEntity: UserEntity)

    @Query("DELETE FROM UserTable")
    fun clear()
}