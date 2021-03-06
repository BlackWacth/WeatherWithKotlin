package com.bruce.weather.domain.model


/**
 * Created by Bruce on 2018/3/22.
 */
data class ForecastList(val id: Long, val city: String, val country: String, val dailyForecast: List<Forecast>) {
    operator fun get(position: Int) = dailyForecast[position]

    val size: Int
        get() = dailyForecast.size
}

data class Forecast(val id: Long, val date: Long, val description: String, val high: Int, val low: Int, val iconUrl: String)