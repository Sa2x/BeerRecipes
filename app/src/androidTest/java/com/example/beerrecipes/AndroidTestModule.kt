package com.example.beerrecipes

import android.content.Context
import com.example.beerrecipes.ui.interactor.beers.BeersInteractor
import com.example.beerrecipes.ui.ui.UIModule
import com.example.beerrecipes.ui.ui.favourite.FavouritesPresenter
import com.example.beerrecipes.ui.ui.list.ListPresenter
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import javax.inject.Singleton

@Module
class AndroidTestModule(context: Context) {

    private val uiModule: UIModule = UIModule(context)

    @Provides
    fun provideContext(): Context {
        return uiModule.context()
    }

    @Provides
    @Singleton
    fun providListPresenter(executor: Executor,beersInteractor: BeersInteractor): ListPresenter {
        return uiModule.listPresenter(executor, beersInteractor)
    }

    @Provides
    @Singleton
    fun provideFavouritesPresenter( beersInteractor: BeersInteractor): FavouritesPresenter {
        return uiModule.favouritesPresenter(beersInteractor)
    }

    @Provides
    @Singleton
    fun provideNetworkExecutor(): Executor {
        return uiModule.networkExecutor()
    }

}