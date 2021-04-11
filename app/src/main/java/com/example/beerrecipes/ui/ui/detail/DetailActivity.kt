package com.example.beerrecipes.ui.ui.detail

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.beerrecipes.ui.model.Beer

class DetailActivity :AppCompatActivity(), DetailScreen{

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    override fun addToFavourites(beer: Beer) {
        TODO("Not yet implemented")
    }

    override fun removeFromFavourites(beer: Beer) {
        TODO("Not yet implemented")
    }

}