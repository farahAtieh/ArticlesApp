package com.frhatieh.articlesapp.domain.usecases

import com.frhatieh.articlesapp.domain.repository.AuthRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class GetCurrentUserUseCase @Inject constructor(
    private val authRepository: AuthRepository
){

    suspend operator fun invoke() = authRepository.currentUser
}