package com.rbmhz.jetpackmvvm.di

import android.content.Context
import androidx.room.Room
import com.rbmhz.jetpackmvvm.core.database.Database
import com.rbmhz.jetpackmvvm.feature.dashboard.data.source.local.BeerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): Database {
        return Room.databaseBuilder(
            context,
            Database::class.java,
            "app_database.db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideBeerDao(db: Database): BeerDao = db.beerDao

}