package com.example.beerrecipes.ui.di


import com.example.beerrecipes.ui.DIReturn
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.*
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun  provideOkHttpClient():DIReturn{
        return DIReturn();
    }

    @Provides
    @Singleton
    fun provideBeersApi():DIReturn{
        return DIReturn();
    }
}