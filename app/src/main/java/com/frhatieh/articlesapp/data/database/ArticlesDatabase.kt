package com.frhatieh.articlesapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.frhatieh.articlesapp.data.database.dao.ArticlesDao
import com.frhatieh.articlesapp.data.model.ArticleEntity

@Database(entities = [ArticleEntity::class], version = 1)
abstract class ArticlesDatabase : RoomDatabase() {
    abstract fun articlesDao(): ArticlesDao
}