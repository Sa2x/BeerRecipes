package com.example.beerrecipes.ui.di


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun  provideOkHttpClient(){

    }

    @Provides
    @Singleton
    fun provideBeersApi(){

    }
}