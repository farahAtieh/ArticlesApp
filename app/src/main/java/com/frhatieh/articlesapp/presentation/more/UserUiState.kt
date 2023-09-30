package com.frhatieh.articlesapp.presentation.more

import androidx.annotation.StringRes
import com.frhatieh.articlesapp.domain.model.User

sealed class UserUiState {
    data class Success(val user: User) : UserUiState()
    data class Error(@StringRes val errorMessageId: Int) : UserUiState()
    data object Loading : UserUiState()
}