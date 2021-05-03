package com.example.beerrecipes.ui.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [BeerModel::class], version = 1, exportSchema = false)
abstract class FavouriteBeerDatabase : RoomDatabase() {
    abstract fun favouriteBeerDao() : FavouriteBeerDao

    private class BeerDatabaseCallback (
        private val scope : CoroutineScope) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

        }
    }

    companion object{
        @Volatile
        private var INSTANCE : FavouriteBeerDatabase? = null

        fun getDatabase(
            context : Context,
            scope : CoroutineScope
        ) : FavouriteBeerDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FavouriteBeerDatabase::class.java,
                    "beers"
                )
                    .addCallback(BeerDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}