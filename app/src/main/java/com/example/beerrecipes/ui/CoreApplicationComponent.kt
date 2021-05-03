package com.example.beerrecipes.ui

import com.example.beerrecipes.ui.di.DatabaseModule
import com.example.beerrecipes.ui.di.NavigatorModule
import com.example.beerrecipes.ui.di.NetworkModule
import com.example.beerrecipes.ui.interactor.InteractorModule
import com.example.beerrecipes.ui.ui.UIModule
import com.example.beerrecipes.ui.ui.detail.DetailActivity
import com.example.beerrecipes.ui.ui.favourite.FavouritesFragment
import com.example.beerrecipes.ui.ui.list.ListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules=[UIModule::class, NetworkModule::class,InteractorModule::class,DatabaseModule::class])
interface CoreApplicationComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(listFragment: ListFragment)
    fun inject(detailActivity: DetailActivity)
    fun inject(favouritesFragment: FavouritesFragment)
}