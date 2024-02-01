package com.rbmhz.jetpackmvvm.di

import com.rbmhz.jetpackmvvm.navigation.Navigator
import dagger.Module
import dagger.Provides
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NavModule {
    @Provides
    @Singleton
    fun provideNavigator(): Navigator {
        return Navigator()
    }
}

@EntryPoint
@InstallIn(SingletonComponent::class)
internal interface NavEntryPoint {
    fun Navigator(): Navigator
}