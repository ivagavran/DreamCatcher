package hr.ferit.ivagavran.dreamcatcher.data

import androidx.room.*
import hr.ferit.ivagavran.dreamcatcher.model.Dream

@Dao
interface DreamDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(dream: Dream)

    @Delete
    fun delete(dream: Dream)

    @Query("SELECT * FROM dreams WHERE id =:id")
    fun getDreamById(id: Long): Dream?

    @Query("SELECT * FROM dreams")
    fun getAllDreams(): List<Dream>
}