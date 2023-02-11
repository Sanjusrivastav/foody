package com.example.foody.ui.fragments

class Constants {

    companion object {
        const val BASE_URL = "https://api.spoonacular.com/"
        const val API_KEY = "140a6c129e0049a792afd42cb9684b23"
        const val BASE_IMAGE_URL = "https://spoonacular.com/cdn/ingredients_100x100/"


        const val RECIPES_RESULT_KEY = "recipesBundle"
// ApiQuery key
        const val  QUERY_SEARCH = "queries"
         const val QUERY_NUMBER = "number"
        const val QUERY_API_KEY= "apiKey"
        const val QUERY_TYPE = "type"
        const val QUERY_DIET = "diet"
        const val QUERY_ADD_RECIPE_INFORMATION = "addRecipeInformation"
        const val QUERY_FILL_INGREDIENTS = "fillIngredients"

        // Room database
        const val DATABASE_NAME = "recipes_dataBase"
        const val RECIPES_TABLE = "recipes_table"
        const val FAVORITE_RECIPES_TABLE = "favorite_recipes_table"
        const val FOOD_JOKE_TABLE = "food_joke_table"



        //BottomSheet and Preferences
         const val  DEFAULT_MEAL_TYPE = "main course"
        const val  DEFAULT_DIET_TYPE = "gluten free"
        const val  DEFAULT_RECIPES_NUMBER = "50"

        const val PREFERENCES_NAME = "foody_preferences"
        const val PREFERENCES_MEAL_TYPE = "mealType"
        const val PREFERENCES_MEAL_TYPE_ID = "mealTypeId"
        const val PREFERENCES_DIET_TYPE = "dietType"
        const val PREFERENCES_DIET_TYPE_ID = "dietTypeId"
        const val PREFERENCE_BACK_ONLINE = "BackOnline"

    }
    }


