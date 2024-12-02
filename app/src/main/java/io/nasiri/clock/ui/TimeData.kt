package io.nasiri.clock.ui

data class TimeData(
    val hours: Pair<Int, Int>,
    val minutes: Pair<Int, Int>,
    val day: Int,
    val monthName: String,
    val dayName: String
)