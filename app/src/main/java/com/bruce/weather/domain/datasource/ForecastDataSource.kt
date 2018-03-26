package com.bruce.weather.domain.datasource

import com.bruce.weather.domain.model.Forecast
import com.bruce.weather.domain.model.ForecastList

/**
 * Created by Bruce on 2018/3/26.
 */
interface ForecastDataSource {
    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?

    fun requestDayForecast(id: Long): Forecast?
}