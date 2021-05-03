package com.example.beerrecipes.ui.ui.favourite

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.beerrecipes.R
import com.example.beerrecipes.ui.data.BeerModel
import com.example.beerrecipes.ui.hide
import com.example.beerrecipes.ui.injector
import com.example.beerrecipes.ui.model.Beer
import com.example.beerrecipes.ui.show
import kotlinx.android.synthetic.main.fragment_favourites.*
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject

class FavouritesFragment :Fragment(), FavouritesScreen {

    @Inject
    lateinit var  favouritesPresenter: FavouritesPresenter

    private val displayedBeers : MutableList<BeerModel> = mutableListOf()

    private var favouritesAdapter: FavouritesAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        favouritesPresenter.attachScreen(this)
        return inflater.inflate(R.layout.fragment_favourites,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val glm = GridLayoutManager(context,2, GridLayoutManager.VERTICAL,false)
        recyclerViewFavourites.layoutManager = glm

        favouritesAdapter = FavouritesAdapter(requireContext(),displayedBeers)
        favouritesAdapter!!.onItemClick={
            favourite->favouritesPresenter.deleteFavourite(favourite)
        }

        recyclerViewFavourites.adapter = favouritesAdapter

        swipeRefreshLayoutFavourites.setOnRefreshListener {
            favouritesPresenter.refreshFavourites()
        }
    }

    override fun onResume() {
        super.onResume()
        favouritesPresenter.refreshFavourites()

    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector.inject(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        favouritesPresenter.detachScreen(this)
    }
    override fun showFavourites(favourites: List<BeerModel>) {
        swipeRefreshLayoutFavourites.isRefreshing=false
        Log.d("RHIVODIK",favourites.toString())
        displayedBeers.clear()
        if(favourites!=null){
            displayedBeers.addAll(favourites)
        }
        favouritesAdapter?.notifyDataSetChanged()

        if(displayedBeers.isEmpty()){
            recyclerViewFavourites.hide()
        }
        else{
            recyclerViewFavourites.show()
        }
    }

}