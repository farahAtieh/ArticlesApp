package com.frhatieh.articlesapp.presentation.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.frhatieh.articlesapp.ScreenRoutes
import com.frhatieh.articlesapp.presentation.splash.SplashScreen
import com.frhatieh.articlesapp.presentation.home.HomeScreen
import com.frhatieh.articlesapp.presentation.login.LoginScreen
import com.frhatieh.articlesapp.presentation.register.RegisterScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.Splash.route
    ) {
        composable(route = ScreenRoutes.Splash.route) {
            SplashScreen(navController)
        }

        composable(route = ScreenRoutes.Login.route) {
            LoginScreen(navController)
        }
        composable(route = ScreenRoutes.Register.route) {
            RegisterScreen(navController)
        }
        composable(route = ScreenRoutes.Home.route) {
            HomeScreen()
        }


    }
}