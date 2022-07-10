package com.tutorials180.fadp42app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.tutorials180.fadp42app.Adapters.AdapterActivity
import com.tutorials180.fadp42app.BrWorking.BRWorkingActivity
import com.tutorials180.fadp42app.CustomListAdapter.CustomListActivity
import com.tutorials180.fadp42app.FBWorking.FirestoreWorkingActivity
import com.tutorials180.fadp42app.GeoLocations.GeoLocationActivity
import com.tutorials180.fadp42app.RoomLib.RoomLibActivity
import com.tutorials180.fadp42app.SMSManager.SMSManagerActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var firstValueET:EditText = findViewById(R.id.firstValueET)
        var secondValueET:EditText = findViewById(R.id.secondValueET)

        var resultBtn:Button = findViewById(R.id.resultBtn)
        var resultTV:TextView = findViewById(R.id.resultTV)

        var startAdapterActivity:Button = findViewById(R.id.startAdapterActivityBtn)
        var startCustomAdapterActivity:Button = findViewById(R.id.startCustomdapterActivityBtn)
        var result =0
        resultBtn.setOnClickListener {
           //Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show();

            if(firstValueET.text.isNotBlank() && secondValueET.text.isNotBlank()) {
                val val1 = firstValueET.text.toString().toInt()
                val val2 = secondValueET.text.toString().toInt()

                result = val1 + val2
                resultTV.text = "Result is:" + result.toString()
            }
            else if(firstValueET.text.isBlank())
            {
                Toast.makeText(MainActivity@this, "First ET is blank", Toast.LENGTH_SHORT).show();
                firstValueET.requestFocus()
            }
            else if(secondValueET.text.isBlank())
            {
                Toast.makeText(MainActivity@this, "Second ET is blank", Toast.LENGTH_SHORT).show();
                    secondValueET.requestFocus()
            }
        }

        val startActBtn:Button = findViewById(R.id.startActBtn)
//        startActBtn.setOnClickListener {
//           var objIntent = Intent(MainActivity@this,SecondActivity::class.java)
//
//            objIntent.putExtra("n",result)
//            objIntent.putExtra("userName","Ali Raza")
//            startActivity(objIntent)
//
//        }

//        startAdapterActivity.setOnClickListener {
//            startActivity(Intent(MainActivity@this,AdapterActivity::class.java))
//        }
//
//        startCustomAdapterActivity.setOnClickListener {
//            startActivity(Intent(MainActivity@this,GeoLocationActivity::class.java))
//        }

//        startCustomAdapterActivity.setOnClickListener {
//            startActivity(Intent(MainActivity@this,RoomLibActivity::class.java))
//        }

//        startCustomAdapterActivity.setOnClickListener {
//            startActivity(Intent(MainActivity@this,FirestoreWorkingActivity::class.java))
//        }

        startCustomAdapterActivity.setOnClickListener {
            startActivity(Intent(MainActivity@this,BRWorkingActivity::class.java))
        }

    }
}