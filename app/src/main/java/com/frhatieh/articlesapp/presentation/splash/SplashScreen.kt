package com.frhatieh.articlesapp.presentation.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.frhatieh.articlesapp.ScreenRoutes

@Composable
fun SplashScreen(navController: NavHostController,
                 viewModel: SplashViewModel = hiltViewModel()) {

    val isAuthenticated by viewModel.isAuthenticated.collectAsState()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        LaunchedEffect(Unit) {
            if (isAuthenticated) {
                navController.navigate(ScreenRoutes.Home.route)
            } else {
                navController.navigate(ScreenRoutes.Login.route)
            }
        }
    }
}