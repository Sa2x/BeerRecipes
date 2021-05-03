package com.example.beerrecipes.ui.interactor.beers.event

import com.example.beerrecipes.ui.model.Beer

data class GetBeersEvent(
    var code: Int = 0,
    var beers: List<Beer>?=null,
    var throwable: Throwable? = null
)