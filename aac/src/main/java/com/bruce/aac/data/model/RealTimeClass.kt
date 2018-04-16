package com.bruce.aac.data.model

/**
 * 风
 * direction 风向。单位是度。正北方向为0度，顺时针增加到360度
 * speed 风速，米制下是公里每小时
 */
data class Wind(val direction: Double, val speed: Double)

/**
 * 最近的降水带
 * status 状态
 * distance 距离
 * intensity 降水强度
 */
data class Nearest(val status: String, val distance: Double, val intensity: Double)

/**
 * 本地的降水
 * status 状态
 * intensity 降水强度，这是彩云自定义的一个量。如果需要mm/h，请在请求中加参数 ?unit=metric:v2
 * datasource 数据源
 */
data class Local(val status: String, val intensity: Double, val datasource: String)

/**
 * 降水
 * nearest 最近的降水带
 * local 本地的降水
 */
data class Precipitation(val nearest: Nearest, val local: Local)

/**
 * 详细结果
 * temperature 温度
 * skycon 天气概况(CLEAR_DAY：晴天, CLEAR_NIGHT：晴夜, PARTLY_CLOUDY_DAY：多云, PARTLY_CLOUDY_NIGHT：多云CLOUDY：阴, RAIN： 雨, SNOW：雪, WIND：风, FOG：雾, HAZE：霾, SLEET：冻雨)
 * pm25 pm25值
 * cloudrate 云量
 * humidity 相对湿度
 */
data class Result(val status: String, val o3: Int, val co: Double, val temperature: Double, val pm10: Int,
                  val skycon: String, val cloudrate: Int, val aqi: Int, val no2: Int, val humidity: Double,
                  val pres: Double, val pm25: Int, val so2: Int, val precipitation: Precipitation, val wind: Wind)

/**
 * 实时天气
 * lang 语言
 * server_time 服务时间
 * tzshift 时区的偏移秒数
 * location 位置，经纬度，（0：纬度， 1： 经度）
 * unit 目前只支持米制（metric）和科学计量法（SI）
 */
data class RealTime(val status: String, val lang: String, val server_time: Long, val tzshift: Long,
                    val location: ArrayList<Double>, val unit: String, val result: Result)