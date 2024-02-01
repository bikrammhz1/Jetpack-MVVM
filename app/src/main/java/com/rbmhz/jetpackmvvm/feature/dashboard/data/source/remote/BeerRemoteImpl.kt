package com.rbmhz.jetpackmvvm.feature.dashboard.data.source.remote

import com.rbmhz.jetpackmvvm.core.api.ApiServices

interface BeerInterface {
    suspend fun getBeer(page: Int, pageCount: Int): List<BeerDto>
}

class BeerRemoteImpl(
    private val apiServices: ApiServices
) : BeerInterface {
    override suspend fun getBeer(page: Int, pageCount: Int): List<BeerDto> {
        return apiServices.getBeers(
            page = page,
            pageCount = pageCount
        )
    }
}
