package com.example.beerrecipes.ui.ui.favourite

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.beerrecipes.R
import com.example.beerrecipes.ui.data.BeerModel
import com.example.beerrecipes.ui.model.Beer
import kotlinx.android.synthetic.main.card_beer.view.*
import kotlinx.android.synthetic.main.card_beer.view.ivImage
import kotlinx.android.synthetic.main.card_beer.view.tvName
import kotlinx.android.synthetic.main.card_beer.view.tvTagline
import kotlinx.android.synthetic.main.card_favourite.view.*

class FavouritesAdapter constructor(private val context: Context, private var favourites: List<BeerModel>):RecyclerView.Adapter<FavouritesAdapter.ViewHolder>() {
    var onItemClick: ((BeerModel)->Unit)? = null

    inner class ViewHolder(view: View) :RecyclerView.ViewHolder(view){
        var ivImage : ImageView = view.ivImage
        var tvName: TextView = view.tvName
        var tvTagline : TextView = view.tvTagline
        var deleteIcon : ImageView = view.delete_icon
        init {
            deleteIcon.setOnClickListener{
                onItemClick?.invoke(favourites[absoluteAdapterPosition])
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.card_favourite,parent,false)
        itemView.minimumHeight=parent.measuredHeight/2
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return favourites.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val favourite =favourites[position]
        favourite.imageurl?.let {
            val image = favourite.imageurl!!
            if(image.isNotEmpty()){
                Glide.with(context).load(image).into(holder.ivImage)
            }
        }

        holder.tvName.text = favourite.name
        holder.tvTagline.text = favourite.tagline
    }
}