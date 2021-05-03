package com.example.beerrecipes.ui.model

import com.google.gson.annotations.SerializedName

class Hop   ( @SerializedName("name")
var name:String? = null,
@SerializedName("amount")
var amount:UnitedValue? = null,
@SerializedName("add")
var add:String? = null,
@SerializedName("attribute")
var attribute:String? = null)
