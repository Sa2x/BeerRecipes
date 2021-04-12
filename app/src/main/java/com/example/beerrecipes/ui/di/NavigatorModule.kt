package com.example.beerrecipes.ui.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import com.example.beerrecipes.ui.navigator.AppNavigator
import com.example.beerrecipes.ui.navigator.AppNavigatorImpl

@InstallIn(ActivityComponent::class)
@Module
abstract class NavigatorModule {

    @Binds
    abstract fun bindNavigator(impl: AppNavigatorImpl): AppNavigator

}