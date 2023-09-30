package com.frhatieh.articlesapp.presentation.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.frhatieh.articlesapp.ScreenRoutes
import com.frhatieh.articlesapp.presentation.component.BottomNavigation
import com.frhatieh.articlesapp.presentation.dashboard.DashboardScreen
import com.frhatieh.articlesapp.presentation.more.MoreScreen

@Composable
fun HomeScreen() {

    val navController = rememberNavController()

    Scaffold(bottomBar = {
        BottomNavigation(navController = navController)
    }) { paddingValue ->
        NavHost(
            modifier = Modifier.padding(paddingValue),
            navController = navController,
            startDestination = ScreenRoutes.Dashboard.route
        ) {
            composable(route = ScreenRoutes.Dashboard.route) {
                DashboardScreen()
            }

            composable(route = ScreenRoutes.Profile.route) {
                MoreScreen()
            }
        }
    }
}