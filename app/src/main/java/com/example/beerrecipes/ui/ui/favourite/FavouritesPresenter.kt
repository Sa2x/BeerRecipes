package com.example.beerrecipes.ui.ui.favourite

import android.util.Log
import com.example.beerrecipes.ui.data.BeerModel
import com.example.beerrecipes.ui.interactor.beers.BeersInteractor
import com.example.beerrecipes.ui.interactor.beers.event.GetBeersEvent
import com.example.beerrecipes.ui.interactor.beers.event.GetFavouritesEvent
import com.example.beerrecipes.ui.model.Beer
import com.example.beerrecipes.ui.ui.Presenter
import com.example.beerrecipes.ui.ui.list.ListScreen
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class FavouritesPresenter @Inject constructor( private val beersInteractor: BeersInteractor) :Presenter<FavouritesScreen>(){

    override fun attachScreen(screen: FavouritesScreen) {
        super.attachScreen(screen)
        if(!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this)
        }
    }

    override fun detachScreen(screen: FavouritesScreen) {
        EventBus.getDefault().unregister(this)
        super.detachScreen(screen)
    }


    fun refreshFavourites(){
        beersInteractor.getFavouriteBeers()

    }

    fun deleteFavourite(beer:BeerModel){
        beersInteractor.removeBeerToFavourite(Beer(beer.id,beer.name,beer.tagline,beer.imageurl))
        refreshFavourites()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: GetFavouritesEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                //screen?.showNetworkError(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                if (event.favourites != null) {
                    screen?.showFavourites(event.favourites as MutableList<BeerModel>)
                }

            }
        }
    }
}