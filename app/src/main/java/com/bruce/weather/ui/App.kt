package com.bruce.weather.ui

import android.app.Application
import com.bruce.weather.extensions.DelegatesExt

/**
 * 单例Application
 * Created by Bruce on 2018/3/23.
 */
class App: Application() {

    companion object {
        var instance: App by DelegatesExt.notNullSigleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}