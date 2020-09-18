package com.example.players.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.players.models.PlayerDetails


@Database(entities = [PlayerDetails::class], version = 1)
abstract class PlayerDetailsDatabase : RoomDatabase() {
    abstract val playerDetailsDAO: PlayerDetailsDAO

    companion object {
        @Volatile
        private var INSTANCE: PlayerDetailsDatabase? = null
        fun getInstance(context: Context): PlayerDetailsDatabase {
            synchronized(this) {
                var instance =
                    INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PlayerDetailsDatabase::class.java,
                        "playerdetails_data_database"
                    ).build()
                }
                return  instance
            }
        }
    }
}