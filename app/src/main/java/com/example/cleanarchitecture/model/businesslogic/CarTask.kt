package com.example.cleanarchitecture.model.businesslogic

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.cleanarchitecture.model.database.CarRepository
import com.example.cleanarchitecture.model.util.CarData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException
import java.util.*

object CarTask {
    private val TAG = this::class.java.canonicalName
    private val scope = CoroutineScope(Dispatchers.IO)
    var getCarList : MutableLiveData<List<CarData>> = MutableLiveData()
    var getInsertCarId : MutableLiveData<Long> = MutableLiveData()

    /**
     * This Method is used to get Car list from database
     * @param context -object of context
     */
    fun getCarListData(context: Context){
        try {
            scope.launch {
                getCarList.postValue(CarRepository.getCarDbInstance(context)
                    .carDao().getCarListData())
            }
        }catch (inputOutputException: IOException){
            Log.e(TAG,"While getting cars from database : " + inputOutputException
            )
        }
    }

    /**
     * This Method is used to save new car id into database
     * @param context -object of context
     */
    fun insertCar(context: Context){
        try {
            scope.launch {
                getInsertCarId.postValue(CarRepository.getCarDbInstance(context)
                    .carDao().insertCar(createCarNameString()))
            }
        }catch (inputOutputException: IOException){
            Log.e(TAG,"While inserting new cars into database : " + inputOutputException
            )
        }
    }

    /**
     * This method is used to create car string.
     */
    private fun createCarNameString(): CarData {
        return CarData("New Car No :- ")
    }
}