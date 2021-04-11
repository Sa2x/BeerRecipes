package com.example.beerrecipes.ui.interactor

import com.example.beerrecipes.ui.MainActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import javax.inject.Singleton

@InstallIn(MainActivity::class)
@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideBeersInteractor(){}
}