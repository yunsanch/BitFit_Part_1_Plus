package com.example.bitfitpart1plus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

import com.example.bitfitpart1plus.databinding.ActivityMainBinding


import com.google.android.material.bottomnavigation.BottomNavigationView
//import com.example.bitfitpart1plus.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

//    private val foods = mutableListOf<DisplayFood>()
//    private lateinit var foodRecyclerView: RecyclerView
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val fragmentManager: FragmentManager = supportFragmentManager

        // define your fragments here
        val logFragment: Fragment = LogListFragment()
        val dashboardListFragment: Fragment = DashboardListFragment()

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)

        // handle navigation selection
        bottomNavigationView.setOnItemSelectedListener { item ->
            lateinit var fragment: Fragment
            when (item.itemId) {
                R.id.nav_log -> fragment = logFragment
                R.id.nav_dashboard -> fragment = dashboardListFragment
            }
//            replaceFragment(ArticleListFragment())
            replaceFragment(fragment)
            true
        }

        // Set default selection
        bottomNavigationView.selectedItemId = R.id.nav_log



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
            val intent2 = Intent(this@MainActivity, ConfirmDeleteActivity::class.java)
            startActivity(intent2)
        }



//        foodRecyclerView = findViewById(R.id.foodListRV)
//
//        val foodAdapter = FoodAdapter(this,foods)
//        foodRecyclerView.adapter = foodAdapter
//
//
//        lifecycleScope.launch {
//            (application as FoodApplication).db.FoodDao().getAll().collect{ databaseList ->
//                databaseList.map {entity ->
//                    DisplayFood(
//                        entity.foodName,
//                        entity.caloriesNumber,
//                        entity.caloriesText
//                    )
//                }.also { mappedList ->
////                    foods.clear()
//                    foods.addAll(mappedList)
//                    foodAdapter.notifyDataSetChanged()
//                }
//            }
//
//    }
//        foodRecyclerView.layoutManager = LinearLayoutManager(this).also {
//            val dividerItemDecoration = DividerItemDecoration(this, it.orientation)
//            foodRecyclerView.addItemDecoration(dividerItemDecoration)
//        }

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
    private fun replaceFragment(AllFragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.log_frame_layout, AllFragment)
        fragmentTransaction.commit()
    }
}