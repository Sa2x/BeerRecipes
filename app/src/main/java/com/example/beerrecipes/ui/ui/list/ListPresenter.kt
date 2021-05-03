package com.example.beerrecipes.ui.ui.list

import android.util.Log
import com.example.beerrecipes.ui.interactor.beers.BeersInteractor
import com.example.beerrecipes.ui.interactor.beers.event.GetBeersEvent
import com.example.beerrecipes.ui.model.Beer
import com.example.beerrecipes.ui.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class ListPresenter @Inject constructor(private val executor:Executor,private val beersInteractor: BeersInteractor): Presenter<ListScreen>() {


    fun refreshBeers(){
        executor.execute {
            Log.i("INFOO","hejhooo")
            beersInteractor.getBeers(1, 80);
        }
    }
    override fun attachScreen(screen: ListScreen) {
        super.attachScreen(screen)
        if(!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this)
        }
    }

    override fun detachScreen(screen: ListScreen) {
        EventBus.getDefault().unregister(this)
        super.detachScreen(screen)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: GetBeersEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showNetworkError(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                if (event.beers != null) {
                    screen?.showBeers(event.beers as MutableList<Beer>)
                }

            }
        }
    }

}