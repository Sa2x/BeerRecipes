package com.example.beerrecipes.ui.model

import com.google.gson.annotations.SerializedName

data class UnitedValue (@SerializedName("value")var value:Float?=null, @SerializedName("unit") var unit:String?=null)