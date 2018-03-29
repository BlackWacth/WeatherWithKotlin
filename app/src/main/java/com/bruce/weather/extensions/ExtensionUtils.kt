package com.bruce.weather.extensions

import java.text.DateFormat
import java.util.*

fun Long.toDataString(dateFormat: Int = DateFormat.MEDIUM): String {
    val df = DateFormat.getDateInstance(dateFormat, Locale.getDefault())
    return df.format(this)
}