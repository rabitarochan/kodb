package com.github.rabitarochan.kotlimapper.util

fun toColumnName(s: String): String {
    acronymRegex.replace(s, { it.value.toLowerCase() }).let {
        startUppercaseRegex.replace(it, { it.value.toLowerCase() }).let {
            return uppercaseRegex.replace(it, { "_${it.value.toLowerCase()}" })
        }
    }
}

private val acronymRegex = Regex("[A-Z]{2,}")
private val startUppercaseRegex = Regex("^[A-Z]{1}")
private val uppercaseRegex = Regex("[A-Z]{1}")
