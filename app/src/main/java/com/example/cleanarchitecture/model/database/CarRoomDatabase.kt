package com.example.cleanarchitecture.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cleanarchitecture.model.util.CarData

/**
 * CarRoomDatabase is abstract and singleton class,
 * which is used to create database instance for car table
 */
@Database(entities = [CarData::class], version = 1, exportSchema = false)
abstract class CarRoomDatabase : RoomDatabase() {

    abstract fun carDao(): CarDao

    companion object {

        @Volatile
        private var INSTANCE: CarRoomDatabase? = null

        fun getDatabase(context: Context): CarRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CarRoomDatabase::class.java,
                    "car_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}
