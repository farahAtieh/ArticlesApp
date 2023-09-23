package com.frhatieh.articlesapp.domain.usecases

import com.frhatieh.articlesapp.domain.model.Response
import com.frhatieh.articlesapp.domain.repository.AuthRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class LoginInUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(email: String, password: String): Response<Boolean> =
        authRepository.loginIn(email, password)
}