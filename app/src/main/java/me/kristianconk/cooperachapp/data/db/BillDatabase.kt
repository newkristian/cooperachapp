package me.kristianconk.cooperachapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [BillEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class BillDatabase: RoomDatabase() {
    abstract fun billDao(): BillDao

    companion object {
        private var INSTANCE: BillDatabase? = null
        const val DB_NAME = "bill_database"

        fun getInstance(context: Context): BillDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }
        }

        private fun buildDatabase(context: Context): BillDatabase {
            // en la primer version no hay plan de migración
            return Room.databaseBuilder(context, BillDatabase::class.java, DB_NAME)
                .addTypeConverter(Converters())
                .fallbackToDestructiveMigration().build()
        }
    }
}