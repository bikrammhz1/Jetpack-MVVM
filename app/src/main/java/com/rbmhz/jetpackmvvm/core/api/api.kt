package com.rbmhz.jetpackmvvm.core.api

import com.rbmhz.jetpackmvvm.feature.dashboard.data.source.remote.BeerDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {

    @GET("beers")
    suspend fun getBeers(
        @Query("page") page: Int,
        @Query("per_page") pageCount: Int
    ): List<BeerDto>

    companion object {
        const val BASE_URL = "https://api.punkapi.com/v2/"
    }
}