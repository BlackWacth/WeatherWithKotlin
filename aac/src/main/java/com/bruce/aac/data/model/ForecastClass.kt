package com.bruce.aac.data.model

data class StringValue(val value: String, val datetime: String)

data class DoubleValue(val value: Double, val datetime: String)

data class IntValue(val value: Int, val datetime: String)

data class ForecastWind(val direction: Double, val speed: Double, val datetime: String)

data class Hourly(val status: String, val description: String, val skycon: ArrayList<StringValue>, val cloudrate: ArrayList<DoubleValue>, val aqi: ArrayList<IntValue>,
                  val humidity: ArrayList<DoubleValue>, val pres: ArrayList<DoubleValue>, val pm25: ArrayList<IntValue>,
                  val precipitation: ArrayList<DoubleValue>, val wind: ArrayList<ForecastWind>, val temperature: ArrayList<DoubleValue>)

data class Minutely(val status: String, val description: String, val probability: ArrayList<Double>, val datasource: String, val precipitation_2h: ArrayList<Double>, val precipitation: ArrayList<Double>)

data class StringValueDate(val index: String, val desc: String, val datetime: String)

data class IntValueDate(val date: String, val max: Int, val avg: Double, val min: Int)

data class DoubleValueDate(val date: String, val max: Double, val avg: Double, val min: Double)

data class Sunset(val time: String)
data class Sunrise(val time: String)
data class Astro(val date: String, val sunset: Sunset, val sunrise: Sunrise)

data class WindSpeed(val direction: Double, val speed: Double)
data class WindDate(val date: String, val max: WindSpeed, val avg: WindSpeed, val min: WindSpeed)

data class Daily(val status: String, val coldRisk: ArrayList<StringValueDate>, val temperature: ArrayList<DoubleValueDate>,
                 val skycon: ArrayList<StringValue>, val cloudrate: ArrayList<DoubleValueDate>, val aqi: ArrayList<IntValueDate>,
                 val astro: ArrayList<Astro>, val pres: ArrayList<DoubleValueDate>, val ultraviolet: ArrayList<StringValueDate>,
                 val pm25: ArrayList<IntValueDate>, val dressing: ArrayList<StringValueDate>, val carWashing: ArrayList<StringValueDate>,
                 val precipitation: ArrayList<DoubleValueDate>, val wind: ArrayList<WindDate>)

data class ForecastResult(val hourly: Hourly, val minutely: Minutely, val daily: Daily, val primary: Int)

data class Forecast(val status: String, val lang: String, val result: ForecastResult, val server_time: Long, val api_status: String, val tzshift: Long,
                    val api_version: String, val unit: String, val location: ArrayList<Double>)