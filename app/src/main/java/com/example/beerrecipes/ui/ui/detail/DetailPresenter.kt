package com.example.beerrecipes.ui.ui.detail

import com.example.beerrecipes.ui.model.Beer
import com.example.beerrecipes.ui.ui.Presenter

class DetailPresenter : Presenter<DetailScreen>(){

    fun addBeerToFavouritesList(beer : Beer){
        screen?.addToFavourites(beer)
    }

    fun removeBeerFromFavouritesList(beer : Beer){
        screen?.removeFromFavourites(beer)
    }
}