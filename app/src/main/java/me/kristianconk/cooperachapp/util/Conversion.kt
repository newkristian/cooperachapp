package me.kristianconk.cooperachapp.util

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Date

fun dateToLocalDateTime(date: Date): LocalDateTime {
    // 1. Convert java.util.Date to Instant
    val instant: Instant = date.toInstant()

    // 2. Convert Instant to LocalDateTime using the system's default time zone
    // You can specify a different ZoneId if needed
    return LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
}

fun localDateTimeToDate(localDateTime: LocalDateTime): Date {
    // 1. Convert LocalDateTime to Instant using the system's default time zone
    // (You should use the same ZoneId you used for the conversion to LocalDateTime)
    val instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant()

    // 2. Convert Instant to java.util.Date
    return Date.from(instant)
}