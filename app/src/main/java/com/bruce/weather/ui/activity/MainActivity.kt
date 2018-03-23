package com.bruce.weather.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.bruce.weather.R
import com.bruce.weather.domain.commands.RequestForecastCommand
import com.bruce.weather.ui.adapters.ForecastListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        forecast_list.layoutManager = LinearLayoutManager(this)
//        val forecastList = findViewById<RecyclerView>(R.id.forecast_list)
//        forecastList.layoutManager = LinearLayoutManager(this)

        val zipCode = "94043"
        async() {
            val result = RequestForecastCommand(zipCode).execute()
            Log.i(javaClass.simpleName, "result = " + result)
            uiThread {
                forecast_list.adapter = ForecastListAdapter(result) {
                    toast(it.date)
                }
            }
        }
    }
}
