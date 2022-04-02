package hr.ferit.ivagavran.dreamcatcher.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "dreams")
data class Dream(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "color")
    val color: DreamColor,
    @ColumnInfo(name = "dateAdded")
    val dateAdded: Date
) {

}