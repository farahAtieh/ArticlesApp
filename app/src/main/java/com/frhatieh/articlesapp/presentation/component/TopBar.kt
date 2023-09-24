package com.frhatieh.articlesapp.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.frhatieh.articlesapp.R
import com.frhatieh.articlesapp.ScreenRoutes
import com.frhatieh.articlesapp.presentation.home.RegistrationPages

@Composable
fun TopBar(
    currentPage: RegistrationPages,
    navigate: (String) -> Unit
) {

    Row(
        Modifier
            .fillMaxWidth()
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

