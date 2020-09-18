package com.example.players.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.players.models.PlayerDetails

@Dao
interface PlayerDetailsDAO {

    @Insert
    suspend fun insertPlayerDetails(playerDetails: PlayerDetails): Long

    @Update
    suspend fun updatePlayerDetails(playerDetails: PlayerDetails): Int

    @Delete
    suspend fun deletePlayerDetails(playerDetails: PlayerDetails): Int

    @Query("DELETE FROM players_data_table")
    suspend fun deleteAll(): Int

    @Query("SELECT * FROM players_data_table")
    fun getAllPlayerDetails(): LiveData<List<PlayerDetails>>
}