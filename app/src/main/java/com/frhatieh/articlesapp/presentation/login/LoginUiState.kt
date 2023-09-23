package com.frhatieh.articlesapp.presentation.login

import com.frhatieh.articlesapp.domain.model.Response

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val emailError: String? = null,
    val passwordError: String? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = "",
    val showToastMessage: Boolean = false,
    val navigateToHome: Boolean = false
)