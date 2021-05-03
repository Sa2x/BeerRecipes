package com.example.beerrecipes.mock

import com.example.beerrecipes.ui.model.Beer
import com.example.beerrecipes.ui.network.BeerApi
import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import kotlin.jvm.Throws

class MockBeerApi:BeerApi {

    override fun beerList(page: Int, perPage: Int): Call<List<Beer>?>? {
        val beers = ArrayList<Beer>()

        val beer = Beer()
        beer.name="Test"
        beer.tagline="TestTagline"
        beer.imageurl="https://i.scdn.co/image/a16c5d95ede008ec905d6ca6d1b5abbf39ad4566"
        beer.abv=1.1f
        beer.ibu=2.2f
        beer.descrirption="very good"

        beers.add(beer)

        val call = object : Call<List<Beer>?> {
            @Throws(IOException::class)
            override fun execute(): Response<List<Beer>?> {
                return Response.success(beers)
            }

            override fun enqueue(callback: Callback<List<Beer>?>) {

            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<List<Beer>?> {
                return this
            }

            override fun request(): Request? {
                return null
            }

            override fun timeout(): Timeout {
                TODO("Not yet implemented")
            }
        }

        return call
    }


    override fun beerFindById(id: Int): Call<List<Beer>?>? {
        val beers = ArrayList<Beer>()

        val beer = Beer()
        beer.name="Test"
        beer.tagline="TestTagline"
        beer.imageurl="https://i.scdn.co/image/a16c5d95ede008ec905d6ca6d1b5abbf39ad4566"
        beer.abv=1.1f
        beer.ibu=2.2f
        beer.descrirption="very good"

        beers.add(beer)

        val call = object : Call<List<Beer>?> {
            @Throws(IOException::class)
            override fun execute(): Response<List<Beer>?> {
                return Response.success(beers)
            }

            override fun enqueue(callback: Callback<List<Beer>?>) {

            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<List<Beer>?> {
                return this
            }

            override fun request(): Request? {
                return null
            }

            override fun timeout(): Timeout {
                TODO("Not yet implemented")
            }
        }

        return call
    }
    }

}