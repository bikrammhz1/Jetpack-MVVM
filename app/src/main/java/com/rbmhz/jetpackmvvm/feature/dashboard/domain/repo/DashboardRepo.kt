package com.rbmhz.jetpackmvvm.feature.dashboard.domain.repo

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.rbmhz.jetpackmvvm.feature.dashboard.data.source.local.BeerEntity

@OptIn(ExperimentalPagingApi::class)
interface DashboardRepo {
    suspend fun load(
        loadType: LoadType, state: PagingState<Int, BeerEntity>
    ): RemoteMediator.MediatorResult
    suspend fun getFakeData(): List<String>
}