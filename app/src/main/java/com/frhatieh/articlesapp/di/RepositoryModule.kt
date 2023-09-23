package com.frhatieh.articlesapp.di

import com.frhatieh.articlesapp.data.repository.AuthRepositoryImpl
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
    fun provideAuthRepository(): AuthRepository =
        AuthRepositoryImpl(
            auth = Firebase.auth,
            dbUsers = FirebaseDatabase.getInstance().getReference("users"))
}