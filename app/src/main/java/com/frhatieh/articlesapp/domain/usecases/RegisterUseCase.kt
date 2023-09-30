package com.frhatieh.articlesapp.domain.usecases

import com.frhatieh.articlesapp.domain.model.Response
import com.frhatieh.articlesapp.domain.repository.AuthRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class RegisterUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(
        email: String,
        password: String,
        nationalId: String,
        phoneNumber: String,
        fullName: String,
        dataOfBirth: String
    ): Response<Boolean> =
        authRepository.register(email, password, nationalId, phoneNumber, fullName, dataOfBirth)
}