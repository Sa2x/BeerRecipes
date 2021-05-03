package com.example.beerrecipes.ui.interactor.beers

import android.util.Log
import com.example.beerrecipes.ui.data.BeerModel
import com.example.beerrecipes.ui.data.FavouriteBeerRepository
import com.example.beerrecipes.ui.interactor.beers.event.GetBeerEvent
import com.example.beerrecipes.ui.interactor.beers.event.GetBeersEvent
import com.example.beerrecipes.ui.interactor.beers.event.GetFavouritesEvent
import com.example.beerrecipes.ui.model.Beer
import com.example.beerrecipes.ui.network.BeerApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class BeersInteractor @Inject constructor(private var beerApi: BeerApi ,private var beerRepo:FavouriteBeerRepository) {

    val scope = CoroutineScope(Dispatchers.IO)

    fun getBeers(page: Int, limit: Int){
        val event = GetBeersEvent()

        try{
            val beersQueryCall = beerApi.beerList(1,80)
            val response = beersQueryCall?.execute()
            Log.i("inf","hejho")
            Log.d("Response",response?.body().toString())

            if (response != null) {
                event.code = response.code()
                event.beers = response.body()
            }
            EventBus.getDefault().post(event)
        }
        catch(e:Exception){
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }

    fun searchBeers(BeerQuery: String){

    }

    fun getBeerwithId(id: Int){
        Log.d("joo","jooo")
        var event = GetBeerEvent()
        try{
            val beerQueryCall = beerApi.beerFindById(id)
            val response = beerQueryCall?.execute()
            Log.d("Response Beer",response?.body().toString())
            if (response != null) {
                event.code = response.code()
                event.beer = response.body()!!.get(0)
                event.isFavourite =
                    beerRepo.getAll().filter { beerModel -> beerModel.id == id }.isNotEmpty()
            }
            EventBus.getDefault().post(event)

        }
        catch(e:Exception){
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }
    fun addBeerToFavourite(beer : Beer){
        scope.launch {
             beerRepo.addOne(BeerModel(beer.id!!,beer.name,beer.tagline,beer.imageurl))
        }

    }

    fun removeBeerToFavourite(beer:Beer){
        scope.launch {
            beerRepo.deleteOne(BeerModel(beer.id!!,beer.name,beer.tagline,beer.imageurl))
        }
    }
    fun getFavouriteBeers() {
        var event = GetFavouritesEvent()
        scope.launch {
            val beers = beerRepo.getAll()
            event.code=200
            event.favourites=beers
            EventBus.getDefault().post(event)
        }
    }


}