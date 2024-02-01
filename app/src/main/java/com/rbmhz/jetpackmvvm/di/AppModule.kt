package com.rbmhz.jetpackmvvm.di

import android.content.Context
import com.rbmhz.jetpackmvvm.core.database.Database
import com.rbmhz.jetpackmvvm.feature.dashboard.data.repo.DashboardRepoImpl
import com.rbmhz.jetpackmvvm.feature.dashboard.data.source.local.BeerDao
import com.rbmhz.jetpackmvvm.feature.dashboard.data.source.remote.BeerRemoteImpl
import com.rbmhz.jetpackmvvm.feature.dashboard.domain.repo.DashboardRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideContext(@ApplicationContext context: Context): Context {
        return context
    }

    @Provides
    @Singleton
    fun provideDashboardRepo(
        db: Database,
        dao: BeerDao,
        apis: BeerRemoteImpl
    ): DashboardRepo {
        return DashboardRepoImpl(db = db, dao = dao, beerRemoteApi = apis)
    }
}