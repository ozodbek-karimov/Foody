package pl.ozodbek.foody.data.database.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import pl.ozodbek.foody.models.FoodJoke
import pl.ozodbek.foody.util.Constants.Companion.FOOD_JOKE_TABLE

@Entity(tableName = FOOD_JOKE_TABLE)
class FoodJokeEntity(

    @Embedded
    var foodJoke: FoodJoke

) {

    @PrimaryKey(autoGenerate = false)
    var id: Int = 0

}