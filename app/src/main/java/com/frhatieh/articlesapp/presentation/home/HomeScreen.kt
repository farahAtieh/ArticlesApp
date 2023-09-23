package com.frhatieh.articlesapp.presentation.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.frhatieh.articlesapp.R
import com.frhatieh.articlesapp.ScreenRoutes

@Composable
fun HomeScreen(navController: NavController,
               viewModel: HomeViewModel = hiltViewModel()) {

    val state by viewModel.uiState.collectAsState()

    CompositionLocalProvider(
        LocalLayoutDirection provides
                if (LocalConfiguration.current.layoutDirection == LayoutDirection.Rtl.ordinal) {
                    LayoutDirection.Rtl
                } else LayoutDirection.Ltr
    ) {
        Column(
            Modifier
                .padding(
                    top = 20.dp,
                    start = 40.dp,
                    end = 40.dp
                )
                .fillMaxWidth(),
        ) {
            Text(
                text = "NYTimes Articles",
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center),
            )
            Spacer(modifier = Modifier.height(20.dp))


            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                when (state.currentSelectedPage) {
                    RegistrationPages.LOGIN -> {
                        navController.navigate(ScreenRoutes.Login.route)
                    }

                    RegistrationPages.REGISTER -> {
                        navController.navigate(ScreenRoutes.Register.route)
                    }
                }
            }


        }
    }

}

@Composable
fun TopBar(
    currentPage: RegistrationPages,
    navigate: (String) -> Unit
) {

    Row(
        Modifier.fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.login),
            color = Color.Black,
            fontSize = 14.sp,
            fontWeight = if (currentPage == RegistrationPages.LOGIN) FontWeight.Bold else FontWeight.Normal,
            textDecoration = if (currentPage == RegistrationPages.LOGIN) TextDecoration.Underline else null,
            modifier = Modifier.clickable {
                navigate(ScreenRoutes.Login.route)
            }
        )

        Text(
            text = stringResource(id = R.string.register),
            color = Color.Black,
            fontSize = 14.sp,
            fontWeight = if (currentPage == RegistrationPages.REGISTER) FontWeight.Bold else FontWeight.Normal,
            textDecoration = if (currentPage == RegistrationPages.REGISTER) TextDecoration.Underline else null,
            modifier = Modifier.clickable {
                navigate(ScreenRoutes.Register.route)
            }
        )
    }
}
