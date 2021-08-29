package com.example.cleanarchitecture.model.database

import android.content.Context

/**
 * This singleton Repository class used to provide instance  of database
 */
object CarRepository {

    /**
     * This function is used to get database instance
     * @param context - object of context
     * @return -- instance of database
     */
    fun getCarDbInstance(context: Context) : CarRoomDatabase {
        return CarRoomDatabase.getDatabase(context)
    }
}