package com.tutorials180.fadp42app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val number=intent.getIntExtra("n",0)
        val userName = intent.getStringExtra("userName")
        Toast.makeText(SecondActivity@this, "Value is $userName and number is $number", Toast.LENGTH_SHORT).show();
    }
}