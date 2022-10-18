package com.example.bitfitpart1plus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

private const val TAG = "LogListFragment"

class LogListFragment : Fragment() {

    // Add these properties
    private val foods = mutableListOf<DisplayFood>()
    private lateinit var logRecyclerView: RecyclerView
    private lateinit var foodAdapter: FoodAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Change this statement to store the view in a variable instead of a return statement
        val view = inflater.inflate(R.layout.fragment_log_list, container, false)

        // Add these configurations for the recyclerView and to configure the adapter
        val layoutManager = LinearLayoutManager(context)
        logRecyclerView = view.findViewById(R.id.log_recycler_view)
        logRecyclerView.layoutManager = layoutManager
        logRecyclerView.setHasFixedSize(true)
        foodAdapter = FoodAdapter(view.context, foods)
        logRecyclerView.adapter = foodAdapter

        // Update the return statement to return the inflated view from above
        return view

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Call the new method within onViewCreated
        fetchFoods()
    }

    private fun fetchFoods() {
        lifecycleScope.launch {


            (activity?.application as FoodApplication).db.FoodDao().getAll().collect{ databaseList ->
                databaseList.map {entity ->
                    DisplayFood(
                        entity.foodName,
                        entity.caloriesNumber,
                        entity.caloriesText
                    )
                }.also { mappedList ->
//                    foods.clear()
                    foods.addAll(mappedList)
                    foodAdapter.notifyDataSetChanged()
                }
            }

        }
    }


    companion object {
        fun newInstance(): LogListFragment {
            return LogListFragment()
        }
    }

}