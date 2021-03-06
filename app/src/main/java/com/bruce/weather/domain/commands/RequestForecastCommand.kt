package com.bruce.weather.domain.commands

import com.bruce.weather.domain.datasource.ForecastProvider
import com.bruce.weather.domain.model.ForecastList

/**
 * Created by Bruce on 2018/3/22.
 */
class RequestForecastCommand(private val zipCode: Long, private val forecastProvider: ForecastProvider = ForecastProvider()): Command<ForecastList> {

    companion object {
        const val DAYS = 7
    }

    override fun execute() = forecastProvider.requestByZipCode(zipCode, DAYS)
}