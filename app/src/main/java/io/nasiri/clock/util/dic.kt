package io.nasiri.clock.util

import android.icu.util.Calendar
import java.text.SimpleDateFormat
import java.util.Locale

val new01 = mapOf(
    0 to listOf(1, 1, 1, 0, 1, 1, 1),
    1 to listOf(0, 0, 1, 0, 0, 1, 0),
    2 to listOf(1, 0, 1, 1, 1, 0, 1),
    3 to listOf(1, 0, 1, 1, 0, 1, 1),
    4 to listOf(0, 1, 1, 1, 0, 1, 0),
    5 to listOf(1, 1, 0, 1, 0, 1, 1),
    6 to listOf(1, 1, 0, 1, 1, 1, 1),
    7 to listOf(1, 0, 1, 0, 0, 1, 0),
    8 to listOf(1, 1, 1, 1, 1, 1, 1),
    9 to listOf(1, 1, 1, 1, 0, 1, 1)
)

fun getCurrentFormattedDateTime(): List<String> {
    val calendar = Calendar.getInstance()
    val dateFormat = SimpleDateFormat("HHmm dd MMM EEEE", Locale.ENGLISH)
    return dateFormat.format(calendar.time).uppercase().split(" ")
}