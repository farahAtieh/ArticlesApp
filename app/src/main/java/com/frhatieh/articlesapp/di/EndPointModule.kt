package com.frhatieh.articlesapp.di

import com.frhatieh.articlesapp.data.network.ArticlesEndPoint
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class EndPointModule {

    @Provides
    fun provideArticlesEndPoint(retrofit: Retrofit): ArticlesEndPoint =
        retrofit.create(ArticlesEndPoint::class.java)
}