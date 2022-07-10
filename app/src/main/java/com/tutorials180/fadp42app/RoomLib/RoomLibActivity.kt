package com.tutorials180.fadp42app.RoomLib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.room.Room
import com.tutorials180.fadp42app.R

class RoomLibActivity : AppCompatActivity()
{

    private lateinit var addDataBtn:Button
    private lateinit var getDataBtn:Button

    private lateinit var mEmployeeDB:EmployeeDb

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_lib)

        addDataBtn = findViewById(R.id.rl_addDataBtn)
        getDataBtn = findViewById(R.id.rl_getDataBtn)

        mEmployeeDB = Room.databaseBuilder(applicationContext,EmployeeDb::class.java,
            "EmployeeDB").allowMainThreadQueries().build()

        addDataBtn.setOnClickListener {
            addDataIntoRL()
        }
        getDataBtn.setOnClickListener {
            getDataFromIntoRL()
        }
    }

    private fun getDataFromIntoRL() {
        var listOfEmployee=mEmployeeDB.getEmpDAO().retrievedAllEmployeeRecord()
        if(listOfEmployee.isNotEmpty())
        {
            var dataOfEmployees=""
            for(singleEmp in listOfEmployee)
            {
                dataOfEmployees += "${singleEmp.id}  ${singleEmp.name}  ${singleEmp.des} \n"
            }

            Toast.makeText(applicationContext, "${dataOfEmployees}", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(applicationContext, "List of empty", Toast.LENGTH_SHORT).show();
        }
    }

    var counter =0;
    private fun addDataIntoRL() {
        counter++

        val employeeObject = Employee(counter,"Ali Raza","Lecturer")
        var checker = mEmployeeDB.getEmpDAO().insertEmployeeRecord(employeeObject)

        if(checker !=0L)
        {
            Toast.makeText(applicationContext, "Data Inserted", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(applicationContext, "Data not inserted", Toast.LENGTH_SHORT).show();
        }
    }












}