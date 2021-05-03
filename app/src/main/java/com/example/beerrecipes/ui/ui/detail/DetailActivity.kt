package com.example.beerrecipes.ui.ui.detail

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.beerrecipes.R
import com.example.beerrecipes.ui.injector
import com.example.beerrecipes.ui.model.Beer
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_detail.view.*
import javax.inject.Inject

class DetailActivity :AppCompatActivity(), DetailScreen{

    @Inject
    lateinit var detailPresenter: DetailPresenter


    private lateinit var beer : Beer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_detail)
        injector.inject(this)
        Log.d("CREATE","CREATEL")


    }

    override fun onStart(){
        super.onStart()
        Log.d("START","startol")
        detailPresenter.attachScreen(this)
        val id: Int = intent.getIntExtra("beerid",0)
        detailPresenter.getBeer(id)

    }

    fun starClicked(view: View){
        if(view is CheckBox){
            val checked = view.isChecked
            if(checked){
                detailPresenter.addBeerToFavouritesList(beer)
            }
            else{
                detailPresenter.removeBeerFromFavouritesList(beer)
            }
        }
    }
    override fun onStop(){
        super.onStop()
        detailPresenter.detachScreen(this)
    }
    override fun onResume() {
        super.onResume()
        Log.d("HERE","HERE")

    }
    override fun onDestroy() {
        super.onDestroy()
        //detailPresenter.detachScreen(this)
    }

    override fun addToFavourites(beer: Beer) {
        Toast.makeText(this,beer.name+"  has been added to favourites",Toast.LENGTH_LONG).show()
    }

    override fun removeFromFavourites(beer: Beer) {
        Toast.makeText(this,beer.name+"  has been removed from favourites",Toast.LENGTH_LONG).show()
    }

    override fun showBeer(beer: Beer,isFavourite:Boolean) {
        tvName.text = beer.name
        tvTagline.text = beer.tagline
        beer.imageurl?.let {
            val image = beer.imageurl!!
            if(image.isNotEmpty()){
                Glide.with(this).load(image).into(imageBeer)
            }
        }
        tvDescription.text = beer.descrirption
        star.isChecked = isFavourite
        tvABV.text = beer.abv.toString()
        tvIBU.text = beer.ibu.toString()
        tvTwist.text = beer.method!!.twist
        tvMashDur.text = beer.method!!.mashtemp!![0].duration.toString()
        tvMashTemp.text = beer.method!!.mashtemp!![0].temp!!.value.toString() + " "+ beer.method!!.mashtemp!![0].temp!!.unit.toString()
        tvFermentTemp.text = beer.method!!.fermentation!!.temp!!.value.toString()+ " "+  beer.method!!.fermentation!!.temp!!.unit.toString()
        this.beer=beer
    }

    override fun showNetworkError(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }

}