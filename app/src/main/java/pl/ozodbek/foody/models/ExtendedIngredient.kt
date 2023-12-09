package pl.ozodbek.foody.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class ExtendedIngredient(
    @SerialName("amount")
    val amount: Double,
    @SerialName("consistency")
    val consistency: String,
    @SerialName("image")
    val image: String,
    @SerialName("name")
    val name: String,
    @SerialName("original")
    val original: String,
    @SerialName("unit")
    val unit: String
) : Parcelable