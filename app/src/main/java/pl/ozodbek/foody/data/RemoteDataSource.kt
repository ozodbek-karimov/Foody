package pl.ozodbek.foody.data

import pl.ozodbek.foody.data.network.FoodRecipesApi
import pl.ozodbek.foody.models.FoodJoke
import pl.ozodbek.foody.models.FoodRecipe
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(

    private val foodRecipesApi: FoodRecipesApi

) {

    suspend fun getRecipes(queries: Map<String, String>): Response<FoodRecipe>{
        return foodRecipesApi.getRecipes(queries)
    }

    suspend fun searchRecipes(searchQueries: Map<String, String>): Response<FoodRecipe>{
        return foodRecipesApi.searchRecipes(searchQueries)
    }

    suspend fun getFoodJoke(apiKey: String): Response<FoodJoke> {
        return foodRecipesApi.getFoodJoke(apiKey)
    }
}