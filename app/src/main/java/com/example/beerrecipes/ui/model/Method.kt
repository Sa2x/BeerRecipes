package com.example.beerrecipes.ui.model

import com.google.gson.annotations.SerializedName

data class Method(
    @SerializedName("mash_temp")
    var mashtemp :List<MashTemp>? = null,
    @SerializedName("fermentation")
    var fermentation: Fermentation? =null,
    @SerializedName("twist")
    var twist:String? = null
)
