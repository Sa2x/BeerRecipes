package com.example.beerrecipes.ui

import android.app.Application
import com.example.beerrecipes.ui.ui.UIModule
import dagger.internal.MapFactory.builder

class CoreApplication: Application() {
    lateinit var injector: CoreApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injector = DaggerCoreApplicationComponent.builder().uIModule(UIModule(this)).build()
    }
}