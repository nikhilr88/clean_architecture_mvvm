package com.example.cleanarchitecture.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.cleanarchitecture.model.businesslogic.CarTask
import com.example.cleanarchitecture.model.util.CarData
import java.util.*

/**
 * This View model is used to display car related data.
 */
class CarViewModel(private val app: Application ) : AndroidViewModel(app) {
    var carList : LiveData<List<CarData>> = MutableLiveData()
    private var insertCarId : LiveData<Long> = MutableLiveData()

    //Initializer blocks
    init {
        observeCarList()
        observeNewCarInsertId()
    }

    /**
     * This function is used to observe car list.
     */
    private fun observeCarList(){
        carList = Transformations.map(CarTask.getCarList){
            carList -> carList
        }
    }

    /**
     * This function is used to observe new car insert id.
     */
    private fun observeNewCarInsertId(){
        insertCarId = Transformations.map(CarTask.getInsertCarId){
                carList -> carList
        }
    }

    /**
     * This function is used to handle click on save button and
     * which will insert data into database.
     */
    fun onSaveCarButtonClicked(){
        Log.e("Save-MVVM","click button")
        CarTask.insertCar(app.applicationContext)
    }

    /**
     * This function is used to handle click on get button and
     * which will get car data from database.
     */
   fun onGetCarsButtonClicked(){
       CarTask.getCarListData(app.applicationContext)
   }

}