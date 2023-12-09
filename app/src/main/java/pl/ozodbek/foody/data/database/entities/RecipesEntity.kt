package pl.ozodbek.foody.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import pl.ozodbek.foody.models.FoodRecipe
import pl.ozodbek.foody.util.Constants.Companion.RECIPES_TABLE

@Entity(tableName = RECIPES_TABLE)
class RecipesEntity(

    var foodRecipe: FoodRecipe

) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0

}