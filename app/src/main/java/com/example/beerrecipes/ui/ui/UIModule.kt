package com.example.beerrecipes.ui.ui

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.beerrecipes.ui.interactor.beers.BeersInteractor
import com.example.beerrecipes.ui.ui.detail.DetailPresenter
import com.example.beerrecipes.ui.ui.favourite.FavouritesPresenter
import com.example.beerrecipes.ui.ui.list.ListPresenter
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
class UIModule(private val context: Context) {

    @Provides
    fun context()=context

    @Provides
    @Singleton
    fun listPresenter(executor: Executor,beersInteractor: BeersInteractor) = ListPresenter(executor,beersInteractor)

    @Provides
    @Singleton
    fun detailPresenter(executor: Executor,beersInteractor: BeersInteractor) = DetailPresenter(executor,beersInteractor)

    @Provides
    @Singleton
    fun favouritesPresenter(beersInteractor: BeersInteractor) = FavouritesPresenter(beersInteractor)
    @Provides
    @Singleton
    fun networkExecutor(): Executor = Executors.newFixedThreadPool(1)
}