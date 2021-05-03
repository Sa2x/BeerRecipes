package com.example.beerrecipes.ui.interactor.beers.event

import com.example.beerrecipes.ui.data.BeerModel
import com.example.beerrecipes.ui.model.Beer

data class GetFavouritesEvent(
        var code: Int = 0,
        var favourites: List<BeerModel>?=null,
        var throwable: Throwable? = null
)