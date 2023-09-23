package com.frhatieh.articlesapp.presentation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.frhatieh.articlesapp.domain.usecases.GetCurrentUserUseCase
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val getCurrentUserUseCase: GetCurrentUserUseCase
): ViewModel() {

    private val _isAuthenticated: MutableStateFlow<Boolean> =
        MutableStateFlow(false)

    val isAuthenticated: StateFlow<Boolean> =
        _isAuthenticated.asStateFlow()

    init {
        viewModelScope.launch {
            _isAuthenticated.update {
                getCurrentUserUseCase() != null
            }
        }
    }
}