package com.example.beerrecipes
import com.example.beerrecipes.mock.MockNetworkModule
import com.example.beerrecipes.ui.CoreApplicationComponent
import com.example.beerrecipes.ui.interactor.InteractorModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MockNetworkModule::class, AndroidTestModule::class, InteractorModule::class])
interface AndroidTestComponent : CoreApplicationComponent