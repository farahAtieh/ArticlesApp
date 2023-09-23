package com.frhatieh.articlesapp.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.frhatieh.articlesapp.domain.model.Response
import com.frhatieh.articlesapp.domain.usecases.LoginInUseCase
import com.frhatieh.articlesapp.util.extensions.validateEmail
import com.frhatieh.articlesapp.util.extensions.validatePassword
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    val loginInUseCase: LoginInUseCase
) : ViewModel() {
    private val _uiState: MutableStateFlow<LoginUiState> =
        MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> =
        _uiState.asStateFlow()

    fun updateEmail(email: String) = viewModelScope.launch {
        _uiState.update {
            it.copy(
                email = email
            )
        }
    }

    fun updatePassword(password: String) = viewModelScope.launch {
        _uiState.update {
            it.copy(
                password = password
            )
        }
    }

    fun doLogin() = viewModelScope.launch {
        if (verifyInput()) {
            when (val loginInResponse = loginInUseCase(
                _uiState.value.email,
                _uiState.value.password
            )) {
                is Response.Failure -> {
                    _uiState.update {
                        it.copy(
                            errorMessage = loginInResponse.e.message,
                            showToastMessage = true,
                            isLoading = false
                        )
                    }
                }

                Response.Loading -> {
                    _uiState.update {
                        it.copy(
                            isLoading = true
                        )
                    }
                }

                is Response.Success -> {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            navigateToHome = true
                        )
                    }
                }
            }


        }
    }
    fun toastMessageShown() {
        _uiState.update {
            it.copy(
                showToastMessage = !_uiState.value.showToastMessage
            )
        }
    }


    private fun verifyInput(): Boolean {
        val emailError = uiState.value.email.validateEmail()
        val passwordError = uiState.value.password.validatePassword()
        _uiState.update {
            it.copy(
                emailError = emailError,
                passwordError = passwordError
            )
        }
        return emailError == null && passwordError == null
    }
}