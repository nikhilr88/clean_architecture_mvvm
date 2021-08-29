package com.example.cleanarchitecture.model.util

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * This data class is used to hold car data.
 */
@Entity(tableName = "car_table")
data class CarData(
    @ColumnInfo(name = "car_name")
    var car_name : String
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name= "id")
    var id : Long? = null
}
