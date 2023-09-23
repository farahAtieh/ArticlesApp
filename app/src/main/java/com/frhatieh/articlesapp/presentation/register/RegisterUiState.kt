package com.frhatieh.articlesapp.presentation.register

import com.frhatieh.articlesapp.domain.model.Response

data class RegisterUiState(
    val email: String = "",
    val password: String = "",
    val fullName: String = "",
    val nationalId: String? = "",
    val phoneNumber: String? = "",
    val dateOfBirth: String? = "",
    val emailError: String? = null,
    val passwordError: String? = null,
    val fullNameError: String? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = "",
    val showToastMessage: Boolean = false,
    val navigateToHome: Boolean = false,

)