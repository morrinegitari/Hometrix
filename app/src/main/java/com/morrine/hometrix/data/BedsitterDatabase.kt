package com.morrine.hometrix.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.morrine.hometrix.model.Bedsitter

import com.morrine.hometrix.model.User

@Database(entities = [Bedsitter::class, User::class], version = 3, exportSchema = false)
abstract class BedsitterDatabase : RoomDatabase() {
    abstract fun bedsitterDao(): BedsitterDao
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE:BedsitterDatabase? = null

        fun getDatabase(context: Context): BedsitterDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BedsitterDatabase::class.java,
                    "main_database"
                )
                    .fallbackToDestructiveMigration() // 💥 This clears DB on version change
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
