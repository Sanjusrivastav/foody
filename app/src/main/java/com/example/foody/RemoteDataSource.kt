package com.example.foody

import com.example.foody.models.FoodJoke
import com.example.foody.models.FoodRecipe
import com.example.foody.models.FoodRecipesApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap
import java.lang.reflect.Constructor
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val foodRecipesApi: FoodRecipesApi)
 {
    suspend  fun getRecipes(queries:Map<String,String>):Response<FoodRecipe>{
        return foodRecipesApi.getRecipes(queries)
    }
     suspend fun searchRecipes( searchQuery: Map<String, String>): Response<FoodRecipe> {
         return foodRecipesApi.searchRecipes(searchQuery)
     }
     suspend fun getFoodJoke(apiKey: String): Response<FoodJoke> {
         return foodRecipesApi.getFoodJoke(apiKey)
     }


 }