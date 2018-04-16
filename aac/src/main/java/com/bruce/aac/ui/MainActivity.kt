package com.bruce.aac.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bruce.aac.R
import com.bruce.aac.data.server.ServerRequest
import org.jetbrains.anko.doAsync

class MainActivity : AppCompatActivity() {

    private val location = listOf("114.117273", "22.531844")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val request = ServerRequest(location[0], location[1])
        doAsync {
            request.requestRealTime()
            request.requestForecast()
        }
    }
}
