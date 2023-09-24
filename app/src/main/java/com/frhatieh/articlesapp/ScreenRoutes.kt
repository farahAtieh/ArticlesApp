package com.frhatieh.articlesapp

sealed class ScreenRoutes(val route: String) {
    data object Splash: ScreenRoutes("splash")
    data object Login: ScreenRoutes("login")
    data object Register: ScreenRoutes("register")
    data object Home: ScreenRoutes("home")
    data object Dashboard: ScreenRoutes("dashboard")
    data object Profile: ScreenRoutes("profile")

}