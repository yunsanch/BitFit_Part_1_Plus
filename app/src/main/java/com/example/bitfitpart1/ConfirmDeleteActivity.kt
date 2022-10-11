package com.example.bitfitpart1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ConfirmDeleteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_delete)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val confirmDeletion = findViewById<Button>(R.id.YesclicktoDeletebtn)
        val doNotDelete = findViewById<Button>(R.id.doNotDeleteBtn)



        confirmDeletion.setOnClickListener {
//            val FoodNameEditText = findViewById<EditText>(R.id.foodNameEditText).text.toString()
//            val caloriesNumberEditText = findViewById<EditText>(R.id.caloriesEditText).text.toString()
//            val caloriesStringTExtView = findViewById<TextView>(R.id.CaloriesTextViewD).text.toString()


            lifecycleScope.launch(Dispatchers.IO) {
                (application as FoodApplication).db.FoodDao().removeAll()
            }


            val intent3 = Intent(this@ConfirmDeleteActivity,MainActivity::class.java)
            startActivity(intent3)
        }

        doNotDelete.setOnClickListener{
            val intent3 = Intent(this@ConfirmDeleteActivity,MainActivity::class.java)
            startActivity(intent3)
        }


    }
}