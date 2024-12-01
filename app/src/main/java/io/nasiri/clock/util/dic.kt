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

fun getCurrentTimeData(): TimeData {

    val calendar = Calendar.getInstance()
    val monthFormat = SimpleDateFormat("MMM", Locale.ENGLISH)
    val dayNameFormat = SimpleDateFormat("EEEE", Locale.ENGLISH)

    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    val minute = calendar.get(Calendar.MINUTE)

    return TimeData(
        hours = Pair(hour / 10, hour % 10),
        minutes = Pair(minute / 10, minute % 10),
        day = calendar.get(Calendar.DAY_OF_WEEK),
        month = monthFormat.format(calendar.time),
        dayName = dayNameFormat.format(calendar.time)
    )
}


data class TimeData(
    val hours: Pair<Int, Int>,
    val minutes: Pair<Int, Int>,
    val day: Int,
    val month: String,
    val dayName: String
)