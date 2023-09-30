package com.frhatieh.articlesapp.presentation.more

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.frhatieh.articlesapp.R
import com.frhatieh.articlesapp.domain.model.User
import com.frhatieh.articlesapp.presentation.component.LoadingScreen
import com.frhatieh.articlesapp.util.extensions.relaunch
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun MoreScreen(viewModel: MoreViewModel = hiltViewModel()) {
    val state = viewModel.uiState.collectAsState().value
    val isDataCleared by viewModel.isDataCleared.collectAsState()

    if (isDataCleared) {
        LocalContext.current.relaunch()
    }

    when (state) {
        is UserUiState.Error -> {
            Text(text = stringResource(id = state.errorMessageId))
        }

        UserUiState.Loading -> {
            LoadingScreen()
        }

        is UserUiState.Success -> {
            UserProfile(
                state.user,
                viewModel::logout
            )
        }

    }
}

@Composable
fun UserProfile(user: User, logout: () -> Unit) {

    Column(modifier = Modifier.padding(16.dp)) {

        Text(
            text = stringResource(id = R.string.more),
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Image(
                painter = rememberCoilPainter(request = R.drawable.articles),
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )

            Column(verticalArrangement = Arrangement.Center) {
                Text(
                    text = user.fullName,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = user.email,
                    fontSize = 16.sp
                )
            }
        }

        Column(
            modifier = Modifier.padding(top = 20.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = stringResource(id = R.string.details),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            UserInfoRecord(
                stringResource(id = R.string.national_id),
                user.nationalId
            )
            UserInfoRecord(
                stringResource(id = R.string.phone_number),
                user.phoneNumber
            )
            UserInfoRecord(
                stringResource(id = R.string.date_of_birth),
                user.dateOfBirth
            )
        }

        Column(modifier = Modifier.padding(top = 10.dp)) {
            Text(
                text = stringResource(id = R.string.settings),
                fontSize = 14.sp
            )

            Divider(
                thickness = 1.dp,
                color = Color.Black
            )

            Row(
                modifier = Modifier.clickable {
                    logout()
                },
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = null
                )
                Text(text = stringResource(id = R.string.logout))
            }
        }

    }
}

@Composable
fun UserInfoRecord(recordName: String, value: String) {
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(
            text = recordName,
            fontSize = 14.sp
        )
        Text(
            text = value,
            fontSize = 16.sp
        )
    }
}
