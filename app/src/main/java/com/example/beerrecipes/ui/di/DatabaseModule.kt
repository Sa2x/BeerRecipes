package com.example.beerrecipes.ui.di

import com.example.beerrecipes.ui.DIReturn
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase():DIReturn{
        return DIReturn();
    }

    @Provides
    fun provideBeerDao():DIReturn{
        return DIReturn();
    }
}