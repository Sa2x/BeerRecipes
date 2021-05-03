package com.example.beerrecipes.ui.data

import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class FavouriteBeerRepository @Inject constructor(private val favouriteBeerDao: FavouriteBeerDao){

    fun getAll():List<BeerModel>{
        return favouriteBeerDao.getAll();
    }

    suspend fun addOne(beer:BeerModel){

        favouriteBeerDao.insert(beer);
    }

    suspend fun deleteOne(beer: BeerModel){
        favouriteBeerDao.delete(beer)
    }
}