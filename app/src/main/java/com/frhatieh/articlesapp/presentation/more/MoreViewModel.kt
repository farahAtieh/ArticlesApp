package com.frhatieh.articlesapp.presentation.more

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.frhatieh.articlesapp.R
import com.frhatieh.articlesapp.domain.model.Response
import com.frhatieh.articlesapp.domain.usecases.ClearDataUseCase
import com.frhatieh.articlesapp.domain.usecases.GetUserInfoUseCase
import com.frhatieh.articlesapp.domain.usecases.LogoutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoreViewModel @Inject constructor(
    private val getUserInfoUseCase: GetUserInfoUseCase,
    private val logoutUseCase: LogoutUseCase,
    private val clearDataUseCase: ClearDataUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<UserUiState> =
        MutableStateFlow(UserUiState.Loading)

    val uiState: StateFlow<UserUiState> = _uiState

    private val _isDataCleared: MutableStateFlow<Boolean> =
        MutableStateFlow(false)

    val isDataCleared: StateFlow<Boolean> = _isDataCleared.asStateFlow()

    init {
        getUser()
    }

    private fun getUser() {
        viewModelScope.launch {
            when(val userResponse = getUserInfoUseCase()){
                is Response.Failure -> {
                    _uiState.update {
                        UserUiState.Error(R.string.please_try_again_later)
                    }
                }
                Response.Loading -> _uiState.update {
                    UserUiState.Loading
                }
                is Response.Success -> _uiState.update {
                    UserUiState.Success(user = userResponse.data)
                }
            }

        }
    }

    fun logout(){
        viewModelScope.launch {
            when(clearDataUseCase()){
                is Response.Failure -> {
                    _uiState.update {
                        UserUiState.Error(R.string.please_try_again_later)
                    }
                }
                Response.Loading -> {
                    _uiState.update {
                        UserUiState.Loading
                    }
                }
                is Response.Success -> {
                    logoutUseCase()
                    _isDataCleared.update {
                        true
                    }
                }
            }
        }
    }

}