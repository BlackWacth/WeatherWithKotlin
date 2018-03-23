package com.bruce.weather

import android.util.Log
import com.google.gson.Gson
import java.net.URL

/**
 * Created by Bruce on 2018/3/21.
 */
public class ForecastRequest(val zipCode: String) {
    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL_STR = "http://api.openweathermap.org/data/2.5/" +"forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$URL_STR&APPID=$APP_ID&q="
    }

    fun execute(): ForecastResult {
        val forecastJsonStr = URL(COMPLETE_URL + zipCode).readText()
        Log.i(javaClass.simpleName, forecastJsonStr)
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}