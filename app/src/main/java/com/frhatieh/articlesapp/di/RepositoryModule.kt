package com.frhatieh.articlesapp.di

import com.frhatieh.articlesapp.data.datasource.LocalDataSource
import com.frhatieh.articlesapp.data.datasource.RemoteDataSource
import com.frhatieh.articlesapp.data.datasource.UserLocalDataSource
import com.frhatieh.articlesapp.data.repository.ArticlesRepositoryImpl
import com.frhatieh.articlesapp.data.repository.AuthRepositoryImpl
import com.frhatieh.articlesapp.domain.repository.ArticlesRepository
import com.frhatieh.articlesapp.domain.repository.AuthRepository
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

    @Provides
    fun provideAuthRepository(userLocalDataSource: UserLocalDataSource): AuthRepository =
        AuthRepositoryImpl(
            auth = Firebase.auth,
            dbUsers = FirebaseDatabase.getInstance().getReference("users"),
            localDataSource = userLocalDataSource)

    @Provides
    fun provideArticlesRepository(localDataSource: LocalDataSource, remoteDataSource: RemoteDataSource): ArticlesRepository =
        ArticlesRepositoryImpl(localDataSource, remoteDataSource)
}