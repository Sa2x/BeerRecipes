package com.example.beerrecipes.ui.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavouriteBeerDao {


    @Query("SELECT * FROM 'beers'")
    fun getAll():List<BeerModel>

    @Insert
    suspend fun insert(beer:BeerModel)

    @Delete
    suspend fun delete(beer:BeerModel)
}
