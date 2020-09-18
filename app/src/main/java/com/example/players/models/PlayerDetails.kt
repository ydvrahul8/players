package com.example.players.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "players_data_table")
data class PlayerDetails(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "player_id")
    val id: Int?=0,
    @ColumnInfo(name = "isKeeper")
    val Iskeeper: Boolean? = false,
    @ColumnInfo(name = "name")
    val Name_Full: String,
    @ColumnInfo(name = "position")
    val Position: String,
    @ColumnInfo(name = "team")
    var team: String? = null,
    @ColumnInfo(name = "isCaptain")
    val Iscaptain: Boolean? = false
):Parcelable