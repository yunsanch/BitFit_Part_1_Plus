package com.example.bitfitpart1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bitfitpart1.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val foods = mutableListOf<DisplayFood>()
    private lateinit var foodRecyclerView: RecyclerView
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        foodRecyclerView = findViewById(R.id.foodListRV)

        val foodAdapter = FoodAdapter(this,foods)
        foodRecyclerView.adapter = foodAdapter

        lifecycleScope.launch {
            (application as FoodApplication).db.FoodDao().getAll().collect{ databaseList ->
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
        foodRecyclerView.layoutManager = LinearLayoutManager(this).also {
            val dividerItemDecoration = DividerItemDecoration(this, it.orientation)
            foodRecyclerView.addItemDecoration(dividerItemDecoration)
        }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        val addButton = findViewById<Button>(R.id.addNewFood)
//
//        addButton.setOnClickListener{
//            val intent = Intent(this@MainActivity,DetailsActivity::class.java)
//
//
//            startActivity(intent)
//        }

        val addButton = findViewById<Button>(R.id.addNewFood)
            addButton.setOnClickListener{
            val intent = Intent(this@MainActivity,DetailsActivity::class.java)


            startActivity(intent)

        }

        val deleteAll = findViewById<Button>(R.id.deleteAllBtn)
        deleteAll.setOnClickListener {
//            val FoodNameEditText = findViewById<EditText>(R.id.foodNameEditText).text.toString()
//            val caloriesNumberEditText = findViewById<EditText>(R.id.caloriesEditText).text.toString()
//            val caloriesStringTExtView = findViewById<TextView>(R.id.CaloriesTextViewD).text.toString()

//            lifecycleScope.launch(Dispatchers.IO) {
//                (application as FoodApplication).db.FoodDao().removeAll()
//            }
            val intent2 = Intent(this@MainActivity,ConfirmDeleteActivity::class.java)
            startActivity(intent2)
        }

//        val deleteBtn = findViewById<Button>(R.id.deleteBtn)
//        deleteBtn.setOnClickListener {
//            val FoodNameEditText = findViewById<EditText>(R.id.foodNameEditText).text.toString()
//            val caloriesNumberEditText = findViewById<EditText>(R.id.caloriesEditText).text.toString()
//            val caloriesStringTExtView = findViewById<TextView>(R.id.CaloriesTextViewD).text.toString()
//
//
//            lifecycleScope.launch(Dispatchers.IO) {
//                (application as FoodApplication).db.FoodDao().delete(
//                    FoodEntity(FoodNameEditText, caloriesNumberEditText,caloriesStringTExtView)
//
//                )
//            }
//
//
////            val intent = Intent(this@DetailsActivity,MainActivity::class.java)
////            startActivity(intent)
//        }

    }
}