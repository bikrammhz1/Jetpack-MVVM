package com.rbmhz.jetpackmvvm.di

import com.rbmhz.jetpackmvvm.core.api.ApiServices
import com.rbmhz.jetpackmvvm.feature.dashboard.data.source.remote.BeerRemoteImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
 @Provides
    @Singleton
    fun provideRetrofitInstance(): ApiServices {
        return Retrofit.Builder()
            .baseUrl(ApiServices.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

    @Singleton
    @Provides
    fun provideBeerApi(apiServices: ApiServices): BeerRemoteImpl {
        return BeerRemoteImpl(apiServices = apiServices)
    }
}