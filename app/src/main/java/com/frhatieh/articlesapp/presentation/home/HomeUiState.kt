package com.frhatieh.articlesapp.presentation.home

data class RegistrationUiState(
    val currentSelectedPage: RegistrationPages = RegistrationPages.LOGIN
)

enum class RegistrationPages(page: String){
    LOGIN("login"),
    REGISTER("register")
}