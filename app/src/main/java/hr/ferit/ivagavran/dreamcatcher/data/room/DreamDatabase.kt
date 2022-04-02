package hr.ferit.ivagavran.dreamcatcher.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import hr.ferit.ivagavran.dreamcatcher.data.DreamDao
import hr.ferit.ivagavran.dreamcatcher.model.Dream

@Database(
    entities = [Dream::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(DreamConverters::class)
abstract class DreamDatabase : RoomDatabase() {
    abstract fun getDreamDao(): DreamDao

    companion object {
        private const val databaseName = "dreamsDb"

        @Volatile
        private var INSTANCE: DreamDatabase? = null

        fun getDatabase(context: Context): DreamDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = buildDatabase(context)
                }
            }
            return INSTANCE!!
        }

        private fun buildDatabase(context: Context): DreamDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                DreamDatabase::class.java,
                databaseName
            )
                .allowMainThreadQueries()
                .build()
        }
    }
}