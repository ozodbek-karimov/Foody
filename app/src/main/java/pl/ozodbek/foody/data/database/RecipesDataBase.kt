package pl.ozodbek.foody.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import pl.ozodbek.foody.data.database.entities.FavoritesEntity
import pl.ozodbek.foody.data.database.entities.FoodJokeEntity
import pl.ozodbek.foody.data.database.entities.RecipesEntity

@Database(
    entities = [RecipesEntity::class, FavoritesEntity::class, FoodJokeEntity::class],
    version = 2,
    exportSchema = false
)

@TypeConverters(RecipesTypeConvertor::class)
abstract class RecipesDataBase: RoomDatabase() {

    abstract fun recipesDao(): RecipesDao

}