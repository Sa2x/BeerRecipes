package com.example.beerrecipes.ui.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import retrofit2.http.Url

@Entity(tableName = "beers")
data class BeerModel(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0,

    @ColumnInfo(name = "name")
    var name: String?,

    @ColumnInfo(name="tagline")
    var tagline:String?,

    @ColumnInfo(name="url")
    var imageurl: String?

)