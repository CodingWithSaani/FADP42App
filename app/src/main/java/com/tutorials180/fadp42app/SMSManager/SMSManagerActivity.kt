package com.tutorials180.fadp42app.SMSManager

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.tutorials180.fadp42app.R

class SMSManagerActivity : AppCompatActivity() {

    private lateinit var smsBodyET:EditText
    private lateinit var smsPhoneET:EditText

    private lateinit var sendSMSBtn:Button
    private lateinit var mSMSManager:SmsManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_smsmanager)

        initializer()
        sendSMSBtn.setOnClickListener {
            sendSMS()
        }
    }

    private fun sendSMS() {
        if(smsBodyET.text.isNotBlank() && smsPhoneET.text.isNotBlank())
        {
           if(
               ActivityCompat.checkSelfPermission(
                   SMSManagerActivity@this,
                   android.Manifest.permission.SEND_SMS
               )==PackageManager.PERMISSION_GRANTED
           )
           {
               mSMSManager.sendTextMessage(
                   smsBodyET.text.toString(),null,smsPhoneET.text.toString(),
                   null, null
               )

               Toast.makeText(applicationContext, "SMS Sent", Toast.LENGTH_SHORT).show();
           }
            else
           {
               Toast.makeText(applicationContext, "You don't have the permission to send sms", Toast.LENGTH_SHORT).show();
               ActivityCompat.requestPermissions(
                   SMSManagerActivity@this,
                   arrayOf(android.Manifest.permission.SEND_SMS),
                   12
               )
           }

        }
        else
        {
            Toast.makeText(SMSManagerActivity@this, "Please fill all fields", Toast.LENGTH_SHORT).show();
        }
    }


    private fun initializer()
    {
        smsBodyET = findViewById(R.id.smsBodyET)
        smsPhoneET = findViewById(R.id.smsPhoneET)

        sendSMSBtn = findViewById(R.id.sendSMSBtn)
        mSMSManager = SmsManager.getDefault()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==12)
        {
            if(grantResults.isNotEmpty() &&
                    grantResults[0]==PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(applicationContext, "Permission Granted", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(applicationContext, "Permission Not Granted", Toast.LENGTH_SHORT).show();
            }

        }
    }














}