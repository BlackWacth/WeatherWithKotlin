package com.bruce.weather.domain.commands

import android.util.Log
import com.bruce.weather.ForecastRequest
import com.bruce.weather.data.server.ForecastDataMapper
import com.bruce.weather.domain.model.ForecastList

/**
 * Created by Bruce on 2018/3/22.
 */
class RequestForecastCommand(private val zipCode: String): Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        Log.i(javaClass.simpleName, "forecastRequest = " + forecastRequest)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}