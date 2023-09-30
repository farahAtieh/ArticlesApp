package com.frhatieh.articlesapp.util.extensions

import android.content.Context
import android.content.Intent
import com.frhatieh.articlesapp.presentation.main.MainActivity

fun Context.relaunch(){
    val intent = Intent(this.applicationContext, MainActivity::class.java)
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
    startActivity(intent)
}