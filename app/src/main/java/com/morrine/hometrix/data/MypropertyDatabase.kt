package com.morrine.hometrix.data


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.morrine.hometrix.model.Myproperty
import com.morrine.hometrix.model.User
import com.morrine.iceberry.data.MypropertyDao



@Database(entities = [Myproperty::class, User::class], version = 3, exportSchema = false)
abstract class MypropertyDatabase : RoomDatabase() {
    abstract fun mypropertyDao(): MypropertyDao
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: MypropertyDatabase? = null

        fun getDatabase(context: Context): MypropertyDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MypropertyDatabase::class.java,
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
