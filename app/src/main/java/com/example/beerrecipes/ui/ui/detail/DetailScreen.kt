package com.example.beerrecipes.ui.ui.detail

import com.example.beerrecipes.ui.model.Beer

interface DetailScreen{
    fun addToFavourites(beer: Beer)
    fun removeFromFavourites(beer:Beer)
    fun showBeer(beer:Beer, isFavourite:Boolean)
    fun showNetworkError(message:String)
}