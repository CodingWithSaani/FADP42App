package com.tutorials180.fadp42app.RoomLib

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "emp_record")
data class Employee(@PrimaryKey @ColumnInfo(name="emp_id") val id:Int, @ColumnInfo(name = "emp_name")
            val name:String, @ColumnInfo(name="emp_des") val des:String)
