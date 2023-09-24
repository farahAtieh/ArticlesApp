package com.frhatieh.articlesapp.presentation.dashboard

import android.widget.Space
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.frhatieh.articlesapp.R
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun DashboardScreen() {
    var isSorted by remember {
        mutableStateOf(false)
    }
    Row (Modifier.fillMaxSize()
        .padding(16.dp)){
        Text(text = stringResource(id = R.string.articles))
        Spacer(modifier = Modifier.weight(1f))
        Row (){
            Icon(modifier = Modifier.size(24.dp), painter = painterResource(id = R.drawable.ic_sort), contentDescription =null )
            Text(text = stringResource(id = R.string.sort),
                fontWeight = if(isSorted) FontWeight.Bold else FontWeight.Normal,
                textDecoration = if(isSorted) TextDecoration.Underline else null,
                modifier = Modifier.clickable {
                    isSorted = !isSorted

                })
        }

    }
}