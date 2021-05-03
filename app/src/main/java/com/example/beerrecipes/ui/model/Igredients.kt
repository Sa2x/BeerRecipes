package com.example.beerrecipes.ui.model

import com.google.gson.annotations.SerializedName

data class Igredients(
    @SerializedName("malt")
    var malt :List<Malt>? = null,
    @SerializedName("hops")
    var hops: List<Hop>? = null,
    @SerializedName("yeast")
    var yeast:String? = null

)