package com.example.cleanarchitecture.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.model.util.CarData
import java.util.*
import java.util.Collections.emptyList

/**
 * This adapter is used to attach car data to recycler view
 * which is taken from database
 */
class CarListAdapter internal constructor(context : Context) :
    RecyclerView.Adapter<CarListAdapter.CarViewHolder>()
{
    private var carList = emptyList<CarData>()
    private val inflater : LayoutInflater = LayoutInflater.from(context)

    inner class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val mCarId : TextView = itemView.findViewById(R.id.text_car_id)
        val mCarName : TextView = itemView.findViewById(R.id.text_car_name)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
    ): CarViewHolder {
        val carsItemRow = inflater.inflate(R.layout.item_car, parent,false)
        return CarViewHolder(carsItemRow)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
       val currentCar = carList[position]
        holder.mCarId.text = currentCar.id.toString()
        holder.mCarName.text = currentCar.car_name
    }

    override fun getItemCount() = carList.size

   internal fun updateData(cars : List<CarData>){
       carList = cars
       notifyDataSetChanged()
   }

}