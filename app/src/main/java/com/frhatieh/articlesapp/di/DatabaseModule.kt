package com.frhatieh.articlesapp.di

import android.content.Context
import androidx.room.Room
import com.frhatieh.articlesapp.data.database.ArticlesDatabase
import com.frhatieh.articlesapp.data.database.dao.ArticlesDao
import com.frhatieh.articlesapp.data.database.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): ArticlesDatabase =
        Room.databaseBuilder(
            appContext,
            ArticlesDatabase::class.java,
            "articles"
        ).build()

    @Provides
    fun provideArticlesDao(articlesDatabase: ArticlesDatabase): ArticlesDao =
        articlesDatabase.articlesDao()

    @Provides
    fun provideUserDao(articlesDatabase: ArticlesDatabase): UserDao =
        articlesDatabase.userDao()
}