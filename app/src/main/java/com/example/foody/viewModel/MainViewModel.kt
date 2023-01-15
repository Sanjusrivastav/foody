package com.example.foody.data.Network

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.foody.NetworkResult
import com.example.foody.Repository
import com.example.foody.models.FoodRecipe
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository,
    application: Application
) : AndroidViewModel(application) {

    val recipesResponse: MutableLiveData<NetworkResult<FoodRecipe>> = MutableLiveData()

    fun getRecipes(queries: HashMap<String, String>) =
        viewModelScope.launch { getRecipesSafeCall(queries) }

    private suspend fun getRecipesSafeCall(queries: HashMap<String, String>) {
        recipesResponse.value = NetworkResult.Loading()

        if (hasInternetConnection()) {
            try {
                val response = repository.remote.getRecipes(queries)
                recipesResponse.value = handleFoodRecipesResponse(response)
                Log.d("MrMain", "$response")
            } catch (e: Exception) {
                recipesResponse.value = NetworkResult.Error("Recipes Not Found")
                Log.d("MrMain", "Recipes Not Found " + e.message.toString())
            }
        } else {
            recipesResponse.value = NetworkResult.Error("NO Internet Connection.")
            Log.d("MrMain", " No Internet")
        }

    }

    private fun handleFoodRecipesResponse(response: Response<FoodRecipe>): NetworkResult<FoodRecipe>? {
        when {
            response.message().toString().contains("timeOut") -> {
                return NetworkResult.Error("Timeout")
            }
            response.code() == 402 -> {
                return NetworkResult.Error("Api Key Limited.")

            }
            response.body()!!.results.isNullOrEmpty() -> {
                return NetworkResult.Error("Recipes not found")

            }
            response.isSuccessful -> {
                val foodRecipe = response.body()
                return NetworkResult.Success(foodRecipe)
            }
            else -> {
                return NetworkResult.Error(response.message())
            }
        }
    }



    @SuppressLint("WrongConstant")
    private fun hasInternetConnection(): Boolean {
        val connectivityManager =
           getApplication<Application>().getSystemService(Context.CONNECTIVITY_SERVICE)
                    as ConnectivityManager
        val activityNetwork = connectivityManager.activeNetwork ?: return false
        val capabilities =
            connectivityManager.getNetworkCapabilities(activityNetwork) ?: return false
        return when {
            capabilities.hasCapability(NetworkCapabilities.TRANSPORT_WIFI) -> true
            capabilities.hasCapability(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            capabilities.hasCapability(NetworkCapabilities.TRANSPORT_ETHERNET) -> true

            else -> false


        }

    }

}