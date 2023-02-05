package com.example.foody.data.Network

import androidx.room.TypeConverter
import com.example.foody.models.ApiResult
import com.example.foody.models.FoodRecipe
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RecipesTypeConverter {

    var gson = Gson()

    @TypeConverter
    fun foodRecipeToString(foodRecipe: FoodRecipe): String {
        return gson.toJson(foodRecipe)
    }

    @TypeConverter
    fun stringToFoodRecipe(data: String): FoodRecipe {
        val listType = object : TypeToken<FoodRecipe>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun resultToString(result: ApiResult): String {
        return gson.toJson(result)

    }
    @TypeConverter
    fun stringToResult(data:String):ApiResult{
        val listType= object :TypeToken<ApiResult>(){}.type
        return gson.fromJson(data,listType)
    }


}
