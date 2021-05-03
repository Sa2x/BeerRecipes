package com.example.beerrecipes.ui.model

import com.google.gson.annotations.SerializedName

data class MashTemp(
    @SerializedName("temp")
    var temp :UnitedValue? = null,
    @SerializedName("duration")
    var duration : Float? =null
)