package com.tutorials180.fadp42app.RoomLib

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface EmpDAO
{
   @Insert
   fun insertEmployeeRecord(employee: Employee):Long

   @Query("select * from emp_record")
   fun retrievedAllEmployeeRecord():List<Employee>
}