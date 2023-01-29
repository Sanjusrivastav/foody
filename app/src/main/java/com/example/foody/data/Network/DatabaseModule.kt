package com.example.foody.data.Network

import android.content.Context
import androidx.room.Room
import com.example.foody.ui.fragments.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun providerDatabase(@ApplicationContext context: Context)= Room.databaseBuilder(context,
        RecipesDatabase::class.java, Constants.DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun providerDao(database: RecipesDatabase )= database.recipesDao()


}