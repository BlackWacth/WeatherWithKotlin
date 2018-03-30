package com.bruce.weather.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.util.Log
import com.bruce.weather.R
import com.bruce.weather.domain.commands.RequestForecastCommand
import com.bruce.weather.extensions.DelegatesExt
import com.bruce.weather.ui.adapters.ForecastListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.uiThread

class MainActivity() : AppCompatActivity(), ToolbarManager {

    override val toolbar by lazy {
        find<Toolbar>(R.id.toolbar)
    }

    private val zipCode: Long by DelegatesExt.preference(this, SettingsActivity.ZIP_CODE, SettingsActivity.DEFAULT_ZIP)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        forecast_list.layoutManager = LinearLayoutManager(this)
        initToolbar()
        attachToScroll(forecast_list)
    }

    override fun onResume() {
        super.onResume()
        loadForecast()
    }

    private fun loadForecast() {
        doAsync {
            val result = RequestForecastCommand(zipCode.toLong()).execute()
            Log.i(javaClass.simpleName, "result = " + result)
            uiThread {
                forecast_list.adapter = ForecastListAdapter(result) {
                    startActivity<DetailActivity>(DetailActivity.ID to it.id, DetailActivity.CITY_NAME to result.city)
                }

                toolbarTitle = "${result.city} (${result.country})"
            }
        }
    }
}
