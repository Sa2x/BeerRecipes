package com.example.beerrecipes.ui.ui.detail

import android.util.Log
import com.example.beerrecipes.ui.interactor.beers.BeersInteractor
import com.example.beerrecipes.ui.interactor.beers.event.GetBeerEvent
import com.example.beerrecipes.ui.interactor.beers.event.GetBeersEvent
import com.example.beerrecipes.ui.model.Beer
import com.example.beerrecipes.ui.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class DetailPresenter @Inject constructor(private val executor: Executor, private val beersInteractor: BeersInteractor) : Presenter<DetailScreen>(){

    fun getBeer(id:Int){
        Log.d("GETTING", id.toString())
        executor.execute{
            beersInteractor.getBeerwithId(id)
        }
    }
    fun addBeerToFavouritesList(beer : Beer){
        beersInteractor.addBeerToFavourite(beer)
        screen?.addToFavourites(beer)
    }

    fun removeBeerFromFavouritesList(beer : Beer){
        beersInteractor.removeBeerToFavourite(beer)
        screen?.removeFromFavourites(beer)
    }

    override fun attachScreen(screen: DetailScreen) {
        super.attachScreen(screen)
        if(!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this)
        }
    }

    override fun detachScreen(screen: DetailScreen) {
        EventBus.getDefault().unregister(this)
        super.detachScreen(screen)

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: GetBeerEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showNetworkError(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                if (event.beer != null) {
                    event.isFavourite?.let { screen?.showBeer(event.beer as Beer, it) }
                }

            }
        }
    }
}