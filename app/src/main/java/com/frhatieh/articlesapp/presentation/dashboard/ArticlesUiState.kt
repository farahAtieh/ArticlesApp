package com.frhatieh.articlesapp.presentation.dashboard

import androidx.annotation.StringRes
import com.frhatieh.articlesapp.data.model.Article

sealed class ArticlesUiState {
    data class Success(val articles: List<Article>) : ArticlesUiState()
    data class Error(@StringRes val errorMessageId: Int) : ArticlesUiState()
    data object Loading : ArticlesUiState()
}