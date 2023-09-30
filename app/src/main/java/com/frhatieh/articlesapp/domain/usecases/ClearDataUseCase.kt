package com.frhatieh.articlesapp.domain.usecases

import com.frhatieh.articlesapp.domain.model.Response
import com.frhatieh.articlesapp.domain.repository.ArticlesRepository
import com.frhatieh.articlesapp.domain.repository.AuthRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ViewModelScoped
class ClearDataUseCase @Inject constructor(
    private val authRepository: AuthRepository,
    private val articlesRepository: ArticlesRepository
) {
    suspend operator fun invoke() =
        withContext(Dispatchers.IO) {
            try {
                async {
                    authRepository.removeUser()
                }.await()
                async {
                    articlesRepository.clearAllArticles()
                }.await()
                Response.Success(true)

            } catch (e: Exception) {
                Response.Failure(e)
            }
        }
}