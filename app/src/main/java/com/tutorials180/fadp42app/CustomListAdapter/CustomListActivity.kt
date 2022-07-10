package com.tutorials180.fadp42app.CustomListAdapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.tutorials180.fadp42app.MainActivity
import com.tutorials180.fadp42app.R

class CustomListActivity : AppCompatActivity()
{
    private var titleList = listOf("t-1","t-1","t-1","t-1","t-1","t-1","t-1","t-1","t-1",
                            "t-1","t-1","t-1","t-1","t-1","t-1","t-1","t-1")

    private var desList = listOf("t-1","t-1","t-1","t-1","t-1","t-1","t-1","t-1","t-1",
        "t-1","t-1","t-1","t-1","t-1","t-1","t-1","t-1")

    private var imagesList = listOf(R.drawable.ba,R.drawable.ba,R.drawable.ba,R.drawable.ba,
        R.drawable.ba,R.drawable.ba,R.drawable.ba,R.drawable.ba,R.drawable.ba,
        R.drawable.ba,R.drawable.ba,R.drawable.ba,R.drawable.ba,
        R.drawable.ba,R.drawable.ba,R.drawable.ba,R.drawable.ba)




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_list)

        var ourCustomListView= findViewById<ListView>(R.id.cListView)
        ourCustomListView.adapter = CustomArrayAdapter(MainActivity@this,
            titleList,desList,imagesList)
    }
}