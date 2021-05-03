package com.example.beerrecipes.ui.di

import dagger.Binds
import dagger.Module
import com.example.beerrecipes.ui.navigator.AppNavigator
import com.example.beerrecipes.ui.navigator.AppNavigatorImpl

@Module
abstract class NavigatorModule {

    @Binds
    abstract fun bindNavigator(impl: AppNavigatorImpl): AppNavigator

}