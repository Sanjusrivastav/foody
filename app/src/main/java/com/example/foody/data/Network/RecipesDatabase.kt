package com.example.foody.data.Network

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.foody.di.RecipesDao
import com.example.foody.di.entities.FavoritesEntity
import com.example.foody.di.entities.RecipesEntity

@Database(
    entities = [RecipesEntity::class, FavoritesEntity::class],
     version = 1,
    exportSchema = false
)
@TypeConverters(RecipesTypeConverter::class)
abstract class RecipesDatabase: RoomDatabase (){
      abstract  fun recipesDao() : RecipesDao
}