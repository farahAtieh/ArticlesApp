package com.frhatieh.articlesapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.frhatieh.articlesapp.data.database.dao.ArticlesDao
import com.frhatieh.articlesapp.data.database.dao.UserDao
import com.frhatieh.articlesapp.data.model.ArticleEntity
import com.frhatieh.articlesapp.data.model.UserEntity

@Database(entities = [ArticleEntity::class, UserEntity::class], version = 1)
abstract class ArticlesDatabase : RoomDatabase() {
    abstract fun articlesDao(): ArticlesDao
    abstract fun userDao(): UserDao

}