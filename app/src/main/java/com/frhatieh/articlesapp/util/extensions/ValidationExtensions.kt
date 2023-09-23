package com.frhatieh.articlesapp.util.extensions

import android.text.TextUtils
import android.util.Patterns

const val MIN_PASSWORD_LENGTH = 8
fun String.validateEmail(): String? = when {
    isEmpty() -> "Email can't be empty!"
    !isValidEmail() -> "Invalid Email"
    else -> null

}

fun String.validatePassword(): String? = when {
    isEmpty() -> "password cannot be empty"
    !isPasswordValid() -> "Minimum password length is $MIN_PASSWORD_LENGTH"
    else -> null
}

fun String.isValidEmail() =
    !TextUtils.isEmpty(this) &&
            Patterns.EMAIL_ADDRESS.matcher(this).matches()

fun String.isPasswordValid() = this.isNotEmpty() && this.length >= MIN_PASSWORD_LENGTH

fun String.validateName(): String? =
    if(!TextUtils.isEmpty(this)) null else "Full Name can't be empty!"