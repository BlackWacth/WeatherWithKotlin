package com.bruce.weather.extensions

/**
 * Created by Bruce on 2018/3/26.
 */
fun <K, V : Any> Map<K, V?>.toVarargArray(): Array<out Pair<String, Any?>> = map { Pair(it.key, it.value!!) }.toTypedArray()