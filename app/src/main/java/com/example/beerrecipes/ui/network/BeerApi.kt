package com.example.beerrecipes.ui.network

import io.swagger.client.CollectionFormats.*
import io.swagger.client.model.Beer
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*
import java.math.BigDecimal

interface BeerApi {
    /**
     * Find a list from the data source.
     *
     * @param page Page id
     * @param perPage Perpage count
     * @return Call<Beer>
    </Beer> */
    @GET("beers")
    fun beerList(
            @Query("page") page: BigDecimal?, @Query("per_page") perPage: BigDecimal?
    ): Call<Beer?>?

    /**
     * Find a model instance by id from the data source.
     *
     * @param id Model id
     * @return Call<Beer>
    </Beer> */
    @GET("beers/{id}")
    fun beerFindById(
            @Path("id") id: BigDecimal?
    ): Call<Beer?>?
}