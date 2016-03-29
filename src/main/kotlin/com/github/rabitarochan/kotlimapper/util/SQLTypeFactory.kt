package com.github.rabitarochan.kotlimapper.util

import java.util.*

fun sqlDateOf(year: Int, month: Int, date: Int): java.sql.Date {
    dateOf(year, month, date, 0, 0, 0, 0).let {
        return java.sql.Date(it.time)
    }
}

fun sqlTimeOf(hour: Int, minute: Int, second: Int): java.sql.Time {
    dateOf(1970, Calendar.JANUARY, 1, hour, minute, second, 0).let {
        return java.sql.Time(it.time)
    }
}

fun sqlTimestampOf(year: Int, month: Int, date: Int, hour: Int, minute: Int, second: Int, milliSecond: Int): java.sql.Timestamp {
    dateOf(year, month, date, hour, minute, second, milliSecond).let {
        return java.sql.Timestamp(it.time)
    }
}

fun dateOf(year: Int, month: Int, day: Int, hour: Int, minute: Int, second: Int, milliSecond: Int = 0): java.util.Date {
    Calendar.getInstance().let {
        it.time = java.util.Date()
        it.set(Calendar.YEAR, year)
        it.set(Calendar.MONTH, month - 1)
        it.set(Calendar.DATE, day)
        it.set(Calendar.HOUR_OF_DAY, hour)
        it.set(Calendar.MINUTE, minute)
        it.set(Calendar.SECOND, second)
        it.set(Calendar.MILLISECOND, milliSecond)
        return it.time
    }
}
