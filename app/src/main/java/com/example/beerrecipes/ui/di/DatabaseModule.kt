package com.example.beerrecipes.ui.di

import android.content.Context
import com.example.beerrecipes.ui.DIReturn
import com.example.beerrecipes.ui.data.FavouriteBeerDao
import com.example.beerrecipes.ui.data.FavouriteBeerDatabase
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Inject
import javax.inject.Singleton


@Module
object DatabaseModule {

    private val applicationScope = CoroutineScope(SupervisorJob())

    //TODO THERE CAN BE PROBLEM WITH APPCONTEXT
    @Provides
    @Singleton
    fun provideDatabase( appContext: Context):FavouriteBeerDatabase{
        return FavouriteBeerDatabase.getDatabase(appContext, applicationScope)
    }

    @Provides
    fun provideBeerDao(favouriteBeerDB: FavouriteBeerDatabase): FavouriteBeerDao=favouriteBeerDB.favouriteBeerDao()
}