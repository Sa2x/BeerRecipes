package com.example.beerrecipes.ui.ui.favourite

import com.example.beerrecipes.ui.data.BeerModel
import com.example.beerrecipes.ui.model.Beer

interface FavouritesScreen {
    fun showFavourites(favourites: List<BeerModel>)

}