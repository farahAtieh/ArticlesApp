package com.frhatieh.articlesapp.presentation.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.frhatieh.articlesapp.domain.model.Response
import com.frhatieh.articlesapp.domain.usecases.RegisterUseCase
import com.frhatieh.articlesapp.util.extensions.validateEmail
import com.frhatieh.articlesapp.util.extensions.validateName
import com.frhatieh.articlesapp.util.extensions.validatePassword
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase
) : ViewModel() {
    private val _uiState: MutableStateFlow<RegisterUiState> =
        MutableStateFlow(RegisterUiState())
    val uiState: StateFlow<RegisterUiState> =
        _uiState.asStateFlow()

    fun updateEmail(email: String) {
        _uiState.update {
            it.copy(
                email = email
            )
        }
    }

    fun updatePassword(password: String) {
        _uiState.update {
            it.copy(
                password = password
            )
        }
    }

    fun updateFullName(fullName: String) {
        _uiState.update {
            it.copy(
                fullName = fullName
            )
        }
    }

    fun updateNationalId(nationalId: String) {
        _uiState.update {
            it.copy(
                nationalId = nationalId
            )
        }
    }

    fun updatePhoneNumber(phoneNumber: String) {
        _uiState.update {
            it.copy(
                phoneNumber = phoneNumber
            )
        }
    }

    fun updateDateOfBirth(dateOfBirth: String) {
        _uiState.update {
            it.copy(
                dateOfBirth = dateOfBirth
            )
        }
    }

    fun register() = viewModelScope.launch {
        if (verifyInput()) {
            when (val loginResponse = registerUseCase(
                _uiState.value.email,
                _uiState.value.password,
                _uiState.value.nationalId ?: "",
                _uiState.value.phoneNumber ?: "",
                _uiState.value.fullName,
                _uiState.value.dateOfBirth ?: "",
                )) {

                is Response.Failure -> {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            showToastMessage = true,
                            errorMessage = loginResponse.e.message
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
        val nameError = uiState.value.fullName.validateName()
        _uiState.update {
            it.copy(
                emailError = emailError,
                passwordError = passwordError,
                fullNameError = nameError
            )
        }
        return emailError == null && passwordError == null && nameError == null
    }
}