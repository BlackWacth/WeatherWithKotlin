package com.bruce.weather.extensions

import android.content.Context
import android.support.v4.content.ContextCompat

fun Context.color(res: Int) = ContextCompat.getColor(this, res)