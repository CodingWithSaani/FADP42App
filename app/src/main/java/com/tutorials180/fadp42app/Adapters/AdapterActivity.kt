package com.tutorials180.fadp42app.Adapters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.tutorials180.fadp42app.R

class AdapterActivity : AppCompatActivity() {

    var weekDays = arrayOf("Monday","Tuesday","Wednesday","Thursday"
                          ,"Friday","Saturday","Sunday")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adapter)

        var myArrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,
                                         weekDays)

        var myListView:ListView = findViewById(R.id.myListView)
        myListView.adapter = myArrayAdapter
    }
}

/*
    Step 1: Define the adapter view
           List View

    Step 2: Define the data source
           Array

    Step 3: Define the adapter
          ArrayAdapter

    Step 4: Connect ListView with ArrayAdapter

 */










