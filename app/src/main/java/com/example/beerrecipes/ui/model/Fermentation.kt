package com.example.beerrecipes.ui.model

import com.google.gson.annotations.SerializedName

data class Fermentation(
    @SerializedName("temp")
    var temp:UnitedValue? = null
)
//        mash_temp: [
//        {
//            temp: {
//            value: 65,
//            unit: "celsius"
//        },
//            duration: 75
//        }
//        ],
//        fermentation: {
//            temp: {
//            value: 10,
//            unit: "celsius"
//        }
//        },
//        twist: null