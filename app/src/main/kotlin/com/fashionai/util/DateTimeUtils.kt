package com.fashionai.util

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

object DateTimeUtils {
    private val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")

    fun formatInstant(instant: Instant): String {
        val localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
        return formatter.format(localDateTime)
    }

    fun getTimeDifferenceInMinutes(from: Instant, to: Instant = Instant.now()): Long {
        return java.time.temporal.ChronoUnit.MINUTES.between(from, to)
    }

    fun isToday(instant: Instant): Boolean {
        val today = LocalDateTime.now()
        val date = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
        return today.toLocalDate() == date.toLocalDate()
    }
}
