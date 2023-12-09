package pl.ozodbek.foody.models


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FoodJoke(
    @SerialName("text")
    val text: String
)