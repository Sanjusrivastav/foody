package com.example.foody.data.Network

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.foody.models.FoodRecipe
import com.example.foody.ui.fragments.Constants.Companion.RECIPES_TABLE

@Entity(tableName = RECIPES_TABLE)
class RecipesEntity( var foodRecipe :FoodRecipe) {
     @PrimaryKey(autoGenerate = false)
     var id :Int = 0
}