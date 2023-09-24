package com.frhatieh.articlesapp.presentation.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.frhatieh.articlesapp.R
import com.frhatieh.articlesapp.ScreenRoutes
import com.frhatieh.articlesapp.presentation.component.CredentialTextField
import com.frhatieh.articlesapp.presentation.component.TopBar
import com.frhatieh.articlesapp.presentation.home.RegistrationPages
import com.frhatieh.articlesapp.util.extensions.showShortToast

@Composable
fun LoginScreen(navController: NavController,
                viewModel: LoginViewModel = hiltViewModel()) {
    val state by viewModel.uiState.collectAsState()
    val context = LocalContext.current

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

            TopBar(
                currentPage = RegistrationPages.LOGIN,
                navigate = navController::navigate
            )

            Column(
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {

                CredentialTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    state.email,
                    state.emailError,
                    stringResource(id = R.string.email),
                    state.emailError != null,
                    viewModel::updateEmail
                )

                CredentialTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    state.password,
                    state.passwordError,
                    stringResource(id = R.string.password),
                    state.passwordError != null,
                    viewModel::updatePassword
                )

                Button(
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(6.dp),
                    onClick = { viewModel.doLogin() }) {
                    Text(text = stringResource(id = R.string.login))
                }
            }

        }

        if(state.isLoading){
            CircularProgressIndicator()
        }else {
            Unit
        }

        if(state.showToastMessage){
            context.showShortToast(state.errorMessage)
            viewModel.toastMessageShown()
        }

        if(state.navigateToHome){
            LaunchedEffect(Unit) {
                navController.navigate(ScreenRoutes.Home.route)
            }
        }
    }
}
