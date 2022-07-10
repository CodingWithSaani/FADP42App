package com.tutorials180.fadp42app.ServicePackage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tutorials180.fadp42app.R

class ServiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        startService(Intent(applicationContext,MyService::class.java))
        stopService(Intent(applicationContext,MyService::class.java))
    }
}