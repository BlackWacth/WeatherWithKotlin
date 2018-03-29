package com.bruce.weather.domain.commands

import com.bruce.weather.domain.datasource.ForecastProvider
import com.bruce.weather.domain.model.Forecast

class RequestDayForecastCommand(val id: Long, val forecastProvider: ForecastProvider = ForecastProvider()) : Command<Forecast> {

    override fun execute(): Forecast = forecastProvider.requestForecast(id)

}