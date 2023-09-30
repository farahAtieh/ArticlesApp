package com.frhatieh.articlesapp.domain.usecases

import com.frhatieh.articlesapp.domain.repository.ArticlesRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class GetPopularViewedArticlesUseCase @Inject constructor(
    private val articlesRepository: ArticlesRepository
) {

    operator fun invoke() =
            articlesRepository.getPopularViewedArticles()

}