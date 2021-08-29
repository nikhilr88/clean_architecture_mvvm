package com.example.cleanarchitecture.view.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cleanarchitecture.viewmodel.CarViewModel
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.databinding.CarFragmentBinding
import com.example.cleanarchitecture.view.adapter.CarListAdapter

class CarFragment : Fragment() {
    private lateinit var viewModel: CarViewModel
    private lateinit var fragmentBinding: CarFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentBinding = DataBindingUtil.inflate(inflater,R.layout.car_fragment, container,
            false )
        //Specify the current activity as the lifecycle owner
        fragmentBinding.lifecycleOwner = requireActivity()
        initialize()
        return fragmentBinding.root
    }

    /**
     * This function is used to initialize view model and other functionality
     */
 private fun initialize(){
     viewModel = ViewModelProvider(requireActivity()).get(CarViewModel::class.java)
        fragmentBinding.viewModel =viewModel
        setObserver()
 }

    /**
     * This function is used observe data of cars
     * and set adapter to recycler view
     */
 private fun setObserver(){
     val adapter = CarListAdapter(requireContext())
        fragmentBinding.recyclerCarListView.adapter = adapter
        fragmentBinding.recyclerCarListView.layoutManager = LinearLayoutManager(requireActivity())

        //Get CarList
        viewModel.carList.observe(requireActivity(), Observer { carList ->
            if (carList.size > 0){
                Toast.makeText(context, "Car Data Fetching.. ", Toast.LENGTH_SHORT).show();

            }else {
                Toast.makeText(context, "No data found ", Toast.LENGTH_SHORT).show();
            }
            adapter.updateData(carList)
        })

 }
}