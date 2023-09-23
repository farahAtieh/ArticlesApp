package com.frhatieh.articlesapp.presentation.component

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun CredentialTextField(
    modifier: Modifier,
    value: String,
    errorMessage: String?,
    placeholderText: String,
    isError: Boolean,
    onClick: (String) -> Unit,
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = {
            onClick(it)
        },
        placeholder = {
            Text(text = placeholderText)
        },
        isError = isError,
        supportingText = {
            if (isError) {
                Text(
                    text = "$errorMessage",
                    color = Color.Red
                )
            }
        })
}