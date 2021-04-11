package com.example.beerrecipes.ui.interactor

import android.app.Activity
import com.example.beerrecipes.ui.DIReturn
import com.example.beerrecipes.ui.MainActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Singleton

@InstallIn(ActivityComponent::class)
@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideBeersInteractor():DIReturn{
        return DIReturn();
    }
}