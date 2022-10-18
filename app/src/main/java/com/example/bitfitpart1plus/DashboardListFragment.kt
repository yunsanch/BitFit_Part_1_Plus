package com.example.bitfitpart1plus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.math.RoundingMode


class DashboardListFragment : Fragment() {
    private val foods = mutableListOf<DisplayFood>()
    private lateinit var dashboardRecyclerView: RecyclerView
    private lateinit var dashboardAdapter: FoodAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        fetchfoods()

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Change this statement to store the view in a variable instead of a return statement
        val view = inflater.inflate(R.layout.averages_item, container, false)

        // Update the return statement to return the inflated view from above
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Call the new method within onViewCreated
        fetchfoods(view)
    }

  private fun fetchfoods(view: View) {
      val avgTextView = view.findViewById<TextView>(R.id.numAvgCalories)
      val miniTextView = view.findViewById<TextView>(R.id.numMinCalories)
      val maxTextView = view.findViewById<TextView>(R.id.numMaxCalories)
      val clearBtn = view.findViewById<Button>(R.id.clearAllBtn)

      var avgCalories = 0.0
      var maxCalories = 0.0
      var minCalories = 0.0


      lifecycleScope.launch(IO){

          avgCalories = (activity?.application as FoodApplication).db.FoodDao().getAvg().toDouble()
          minCalories = (activity?.application as FoodApplication).db.FoodDao().getMin().toDouble()
          maxCalories = (activity?.application as FoodApplication).db.FoodDao().getMax().toDouble()

          avgTextView.text = avgCalories.toBigDecimal().setScale(1,RoundingMode.UP).toString()
          miniTextView.text = maxCalories.toString()
          maxTextView.text = minCalories.toString()

        }
      clearBtn.setOnClickListener{
          avgTextView.text = "0.0"
          miniTextView.text = "0.0"
          maxTextView.text = "0.0"
      }
    }

    companion object {
        fun newInstance(): DashboardListFragment {
            return DashboardListFragment()
        }
    }
}