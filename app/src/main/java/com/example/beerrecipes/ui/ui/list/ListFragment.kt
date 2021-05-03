package com.example.beerrecipes.ui.ui.list

import android.content.ClipData
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Log.INFO
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatViewInflater
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.beerrecipes.R
import com.example.beerrecipes.ui.hide
import com.example.beerrecipes.ui.injector
import com.example.beerrecipes.ui.model.Beer
import com.example.beerrecipes.ui.navigator.AppNavigator
import com.example.beerrecipes.ui.show
import com.example.beerrecipes.ui.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.fragment_list.*
import java.util.logging.Level.INFO
import javax.inject.Inject

class ListFragment :Fragment(),ListScreen {

    @Inject
    lateinit var listPresenter: ListPresenter;

//    @Inject
//    lateinit var navigator: AppNavigator

    private val displayedBeers: MutableList<Beer> = mutableListOf()
    private var listAdapter: ListAdapter? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        listPresenter.attachScreen(this)
        return inflater.inflate(R.layout.fragment_list,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val llm = LinearLayoutManager(context)
        llm.orientation = LinearLayoutManager.VERTICAL
        val glm = GridLayoutManager(context,2,GridLayoutManager.VERTICAL,false)
        recyclerViewBeers.layoutManager = glm

        listAdapter = ListAdapter(requireContext(),displayedBeers)
        listAdapter!!.onItemClick = {
                beer ->
            beer.id?.let {         val intent = Intent(activity, DetailActivity::class.java)
                intent.putExtra("beerid", beer.id!!)
                requireActivity().startActivity(intent) }
        }

        recyclerViewBeers.adapter = listAdapter



        swipeRefreshLayoutBeers.setOnRefreshListener {
           listPresenter.refreshBeers()
        }

    }

    override fun onResume() {
        super.onResume()
        listPresenter.refreshBeers()

    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector.inject(this)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        listPresenter.detachScreen(this)
    }

    override fun showBeers(beers: List<Beer>) {

        swipeRefreshLayoutBeers.isRefreshing=false
        displayedBeers.clear()
        if(beers!= null){
            displayedBeers.addAll(beers)
        }
        listAdapter?.notifyDataSetChanged()

        if(displayedBeers.isEmpty()){
            recyclerViewBeers.hide()
        }
        else{
            recyclerViewBeers.show()
        }
    }


    override fun showNetworkError(message: String) {
        swipeRefreshLayoutBeers.isRefreshing=false
        Toast.makeText(context,message,Toast.LENGTH_LONG).show()
    }
}