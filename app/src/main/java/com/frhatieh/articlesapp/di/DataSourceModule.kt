package com.frhatieh.articlesapp.di

import com.frhatieh.articlesapp.data.database.dao.ArticlesDao
import com.frhatieh.articlesapp.data.datasource.LocalDataSource
import com.frhatieh.articlesapp.data.datasource.RemoteDataSource
import com.frhatieh.articlesapp.data.network.ArticlesEndPoint
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Provides
    fun provideRemoteDataSource(articlesEndPoint: ArticlesEndPoint): RemoteDataSource =
        RemoteDataSource(articlesEndPoint)

    @Provides
    fun provideLocalDataSource(articlesDao: ArticlesDao): LocalDataSource =
        LocalDataSource(articlesDao)
}