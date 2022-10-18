package com.example.bitfitpart1plus

import android.app.Application

class FoodApplication: Application() {
    val db by lazy {
        appDataBase.getInstance(this)
    }
}