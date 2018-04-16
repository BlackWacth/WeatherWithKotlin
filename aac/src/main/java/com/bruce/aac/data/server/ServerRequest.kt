package com.bruce.aac.data.server

import android.util.Log
import java.net.URL


class ServerRequest(private val longitude: String, private val latitude: String) {

    companion object {
        private const val TOKEN = "Fi9eTTfXW=Z-CprP/"
        private const val BASE_URL = "https://api.caiyunapp.com/v2/"
        private const val REAL_TIME = "/realtime.json"
        private const val FORECAST = "/forecast.json"
    }

    private fun getUrl(withEnd: String = REAL_TIME): String = "$BASE_URL$TOKEN$longitude,$latitude$withEnd"

    fun requestRealTime() {
        val result = URL(getUrl(REAL_TIME)).readText()
        Log.i(javaClass.simpleName, "Real Time ---> $result")
    }

    fun requestForecast() {
        val result = URL(getUrl(FORECAST)).readText()
        Log.i(javaClass.simpleName, "Forecast ---> $result")
    }
}