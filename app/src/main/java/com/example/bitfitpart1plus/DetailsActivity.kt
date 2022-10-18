package com.example.bitfitpart1plus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.example.bitfitpart1plus.R
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


//        val FoodNameEditText = findViewById<EditText>(R.id.foodNameEditText).text.toString()
//        val caloriesNumberEditText = findViewById<EditText>(R.id.caloriesEditText).text.toString()
        val saveFoodButton = findViewById<Button>(R.id.SaveFoodBtn)



        saveFoodButton.setOnClickListener {
            val FoodNameEditText = findViewById<EditText>(R.id.foodNameEditText).text.toString()
            val caloriesNumberEditText = findViewById<EditText>(R.id.caloriesEditText).text.toString()
            val caloriesStringTExtView = findViewById<TextView>(R.id.CaloriesTextViewD).text.toString()


            lifecycleScope.launch(IO) {
                (application as FoodApplication).db.FoodDao().insert(
                    FoodEntity(FoodNameEditText, caloriesNumberEditText,caloriesStringTExtView)

                    )
            }


            val intent = Intent(this@DetailsActivity,MainActivity::class.java)
            startActivity(intent)
        }

    }
}