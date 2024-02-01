package com.rbmhz.jetpackmvvm.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rbmhz.jetpackmvvm.feature.dashboard.data.source.local.BeerDao
import com.rbmhz.jetpackmvvm.feature.dashboard.data.source.local.BeerEntity

@Database(
    entities = [BeerEntity::class],
    version = 1
)
abstract class Database: RoomDatabase() {

    abstract val beerDao: BeerDao
}