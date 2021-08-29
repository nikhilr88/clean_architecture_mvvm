package com.example.cleanarchitecture.model.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cleanarchitecture.model.util.CarData
import java.util.*

/**
 * This interface id defines for DB operations related to Car object
 */
@Dao
interface CarDao {

    /**
     * This function is used to insert new car in DB
     * @param carData - single car object
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCar(carData: CarData): Long

    /**
     * This function is used to get car List from database.
     * @
     */
    @Query("SELECT * FROM car_table ORDER BY id ASC")
    fun getCarListData(): List<CarData>
}