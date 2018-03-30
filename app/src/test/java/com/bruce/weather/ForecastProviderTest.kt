package com.bruce.weather

import com.bruce.weather.domain.datasource.ForecastDataSource
import com.bruce.weather.domain.datasource.ForecastProvider
import com.bruce.weather.domain.model.Forecast
import com.bruce.weather.domain.model.ForecastList
import org.junit.Assert
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mockito.*

class ForecastProviderTest {

    @Test
    internal fun testDataSourceReturnsValue() {
        val ds = mock(ForecastDataSource::class.java)
        `when`(ds.requestDayForecast(0)).then { Forecast(0, 0, "desc", 20, 0, "url") }
        val provider = ForecastProvider(listOf(ds))
        println(provider.requestForecast(0))
        Assert.assertNotNull(provider.requestForecast(0))
    }

    @Test
    fun emptyDatabaseReturnServerValue() {
        val db = mock(ForecastDataSource::class.java)
        val server = mock(ForecastDataSource::class.java)
        `when`(server.requestForecastByZipCode(ArgumentMatchers.any(Long::class.java), ArgumentMatchers.any(Long::class.java))).then { ForecastList(0, "city", "country", listOf()) }

        val provider = ForecastProvider(listOf(db, server))
        println(provider.requestByZipCode(0, 0))
        Assert.assertNotNull(provider.requestByZipCode(0, 0))
    }
}