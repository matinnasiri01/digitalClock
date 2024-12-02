package io.nasiri.clock.util

import android.icu.util.Calendar
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import io.nasiri.clock.ui.TimeData
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

fun Int.getDigits(): List<Boolean> {
    require(this in 0..9) { "The number must be between 0 and 9." }
    return new01[this]!!.map { it == 1 }
}

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
        monthName = monthFormat.format(calendar.time),
        dayName = dayNameFormat.format(calendar.time)
    )
}

/**
 * Custom modifier to arrange a layout vertically by swapping the width and height
 * of the measured placeable and adjusting its position to center it in a rotated layout.
 *
 * This modifier measures the content and swaps the width and height dimensions of
 * the resulting placeable, then repositions it by adjusting the `x` and `y` coordinates
 * to align the placeable vertically within its available space.
 *
 * @return A new layout modifier that modifies the placement of the content to be
 *         arranged vertically.
 */
fun Modifier.vertical() = layout { measurable, constraints ->
    val placeable = measurable.measure(constraints)
    layout(placeable.height, placeable.width) {
        placeable.place(
            x = -(placeable.width / 2 - placeable.height / 2),
            y = -(placeable.height / 2 - placeable.width / 2)
        )
    }
}