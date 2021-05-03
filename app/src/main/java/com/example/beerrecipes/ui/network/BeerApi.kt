package com.example.beerrecipes.ui.network

import com.example.beerrecipes.ui.model.Beer
import retrofit2.http.*

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
            @Query("page") page: Int, @Query("per_page") perPage: Int
    ): retrofit2.Call<List<Beer>?>?

    /**
     * Find a model instance by id from the data source.
     *
     * @param id Model id
     * @return Call<Beer>
    </Beer> */
    @GET("beers/{id}")
    fun beerFindById(
            @Path("id") id: Int
    ): retrofit2.Call<List<Beer>?>?
}