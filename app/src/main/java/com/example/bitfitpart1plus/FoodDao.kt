package com.example.bitfitpart1plus

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodDao {
    @Query("SELECT * FROM food_table")
    fun getAll(): Flow<List<FoodEntity>>

    @Insert
    fun insertAll(food: List<FoodEntity>)

    @Insert
    fun insert(food: FoodEntity)

    @Query("DELETE FROM food_table")
    fun removeAll()

    @Delete
    fun delete(food: FoodEntity)

    @Query("SELECT MAX(caloriesNumber) FROM food_table")
    fun getMax(): Float

    @Query("SELECT AVG(caloriesNumber) FROM food_table")
    fun getAvg(): Float

    @Query("SELECT MIN(caloriesNumber) FROM food_table")
    fun getMin(): Float



//    @Delete
//    fun deleteAll(food: FoodEntity)
}