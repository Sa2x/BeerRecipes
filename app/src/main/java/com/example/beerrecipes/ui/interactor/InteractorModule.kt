package com.example.beerrecipes.ui.interactor

import com.example.beerrecipes.ui.data.FavouriteBeerRepository
import com.example.beerrecipes.ui.interactor.beers.BeersInteractor
import com.example.beerrecipes.ui.network.BeerApi
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule {

    @Provides
    @Singleton
    fun provideBeersInteractor(beerApi:BeerApi ,favouriteRepo:FavouriteBeerRepository) = BeersInteractor(beerApi,favouriteRepo)

}