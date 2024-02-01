package com.rbmhz.jetpackmvvm.feature.dashboard.data.source.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface BeerDao {

    @Upsert
    suspend fun upsertAll(beers: List<BeerEntity>)

    @Query("SELECT * FROM BeerEntity")
    fun getBeer(): PagingSource<Int, BeerEntity>

    @Query("DELETE FROM BeerEntity")
    suspend fun clearAll()
}