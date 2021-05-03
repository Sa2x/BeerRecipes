package com.example.beerrecipes.ui.ui.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.beerrecipes.R
import com.example.beerrecipes.ui.model.Beer
import kotlinx.android.synthetic.main.card_beer.view.*

class ListAdapter constructor(private val context: Context, private var beers: List<Beer>):RecyclerView.Adapter<ListAdapter.ViewHolder>(){
    var onItemClick: ((Beer) -> Unit)? = null

    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        var ivImage : ImageView = view.ivImage
        var tvName: TextView = view.tvName
        var tvTagline : TextView = view.tvTagline

        init {
            view.setOnClickListener{
                onItemClick?.invoke(beers[absoluteAdapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ViewHolder {

        val itemView = LayoutInflater.from(context).inflate(R.layout.card_beer,parent,false)
        itemView.minimumHeight=parent.measuredHeight/2
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return beers.size
    }

    override fun onBindViewHolder(holder: ListAdapter.ViewHolder, position: Int) {
        val beer = beers[position]

        beer.imageurl?.let {
            val image = beer.imageurl!!
            if(image.isNotEmpty()){
                Glide.with(context).load(image).into(holder.ivImage)
            }
        }

        holder.tvName.text = beer.name
        holder.tvTagline.text = beer.tagline
    }

}