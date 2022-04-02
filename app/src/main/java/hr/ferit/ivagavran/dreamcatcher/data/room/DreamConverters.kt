package hr.ferit.ivagavran.dreamcatcher.data.room

import androidx.room.TypeConverter
import hr.ferit.ivagavran.dreamcatcher.model.Dream
import hr.ferit.ivagavran.dreamcatcher.model.DreamColor
import java.util.*

class DreamConverters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun toTimestamp(date: Date?): Long? {
        return date?.time
    }
    @TypeConverter
    fun toString(color: DreamColor): String{
        return color.toString()
    }

    @TypeConverter
    fun fromString(color: String): DreamColor{
        return when(color){
            DreamColor.Red.toString() -> DreamColor.Red
            DreamColor.Yellow.toString() -> DreamColor.Yellow
            DreamColor.Blue.toString() -> DreamColor.Blue
            DreamColor.Black.toString() -> DreamColor.Black
            else -> DreamColor.Black
        }
    }
}