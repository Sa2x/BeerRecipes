package com.example.beerrecipes.ui.interactor.beers.event

import com.example.beerrecipes.ui.model.Beer

data class GetBeerEvent(
    var code: Int = 0,
    var beer: Beer?=null,
    var throwable: Throwable? = null,
    var isFavourite: Boolean? = false
)