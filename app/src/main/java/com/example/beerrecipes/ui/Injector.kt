package com.example.beerrecipes.ui


import android.app.Activity
import androidx.fragment.app.Fragment


val Activity.injector: CoreApplicationComponent
    get() {
        return (this.applicationContext as CoreApplication).injector
    }

val Fragment.injector: CoreApplicationComponent
    get() {
        return (this.requireContext().applicationContext as CoreApplication).injector
    }