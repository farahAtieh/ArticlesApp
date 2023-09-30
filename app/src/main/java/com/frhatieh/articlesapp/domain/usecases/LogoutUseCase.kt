package com.frhatieh.articlesapp.domain.usecases

import com.frhatieh.articlesapp.domain.model.Response
import com.frhatieh.articlesapp.domain.model.User
import com.frhatieh.articlesapp.domain.repository.AuthRepository
import javax.inject.Inject

class LogoutUseCase @Inject constructor(
    private val authRepository: AuthRepository,
) {

    suspend operator fun invoke(): Response<Boolean> =
        authRepository.logout()

}