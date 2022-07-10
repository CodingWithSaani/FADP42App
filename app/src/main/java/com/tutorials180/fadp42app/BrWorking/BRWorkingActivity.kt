package com.tutorials180.fadp42app.BrWorking

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.tutorials180.fadp42app.R

class BRWorkingActivity : AppCompatActivity() {

    private lateinit var brTV:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brworking)

        brTV = findViewById(R.id.brTV)
    }

    private val ourBR = object : BroadcastReceiver()
    {
        override fun onReceive(p0: Context?, brIntent: Intent?) {
            when(brIntent?.getIntExtra(WifiManager.EXTRA_WIFI_STATE,WifiManager.WIFI_STATE_UNKNOWN))
            {
                WifiManager.WIFI_STATE_ENABLED ->
                {
                    brTV.text = "WIFI is Enabled"
                }
                WifiManager.WIFI_STATE_DISABLED ->
                {
                    brTV.text = "WIFI is disabled"
                }
            }
        }

    }

    override fun onStart() {
        super.onStart()
        val brIntentFilter = IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION)

        registerReceiver(ourBR,brIntentFilter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(ourBR)
    }
}