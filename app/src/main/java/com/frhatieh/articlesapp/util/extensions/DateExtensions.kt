package com.frhatieh.articlesapp.util.extensions

import android.content.Context
import com.frhatieh.articlesapp.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.math.abs


fun String.formatDateToDaysAgo(context: Context): String {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val currentDate = Date()

    try {
        val customDate = dateFormat.parse(this)
        val timeDifferenceMillis = abs(currentDate.time - customDate.time)
        val days = timeDifferenceMillis / (1000 * 60 * 60 * 24)
        val weeks = days / 7
        val remainingDays = days % 7

        val formattedString = StringBuilder()
        if (weeks > 0) {
            formattedString.append(weeks)
            formattedString.append(if (weeks == 1L)
                " ${context.getString(R.string.week)}" else " ${context.getString(R.string.weeks)}")
        }
        if (remainingDays > 0) {
            if (formattedString.isNotEmpty()) {
                formattedString.append(
                    " ${context.getString(R.string.and_seperater)}"
                )
            }
            formattedString.append(remainingDays)
            formattedString.append(if (remainingDays == 1L)
                " ${context.getString(R.string.day)}" else " ${context.getString(R.string.days)}")
        }

        return if (formattedString.isNotEmpty()) {
            formattedString.append(
                " ${context.getString(R.string.ago)}"
            ).toString()
        } else {
            context.getString(R.string.today)
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }

    return this
}