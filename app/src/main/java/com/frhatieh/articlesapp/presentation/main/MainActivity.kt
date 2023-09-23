package com.frhatieh.articlesapp.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.frhatieh.articlesapp.presentation.dashboard.DashboardScreen
import com.frhatieh.articlesapp.presentation.login.LoginScreen
import com.frhatieh.articlesapp.presentation.register.RegisterScreen
import com.frhatieh.articlesapp.presentation.theme.ArticlesAppTheme
import com.frhatieh.articlesapp.ScreenRoutes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArticlesAppTheme {
                val navController = rememberNavController()
                SetupNavGraph(navController)
            }
        }
    }
}
