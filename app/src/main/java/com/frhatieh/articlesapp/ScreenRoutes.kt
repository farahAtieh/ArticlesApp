package com.frhatieh.articlesapp

sealed class ScreenRoutes(val route: String) {
    data object Splash: ScreenRoutes("splash")
    data object Home: ScreenRoutes("home")
    data object Login: ScreenRoutes("login")
    data object Register: ScreenRoutes("register")

    data object Dashboard: ScreenRoutes("dashboard")
}