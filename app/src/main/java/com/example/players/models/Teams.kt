package com.example.players.models

import com.google.gson.annotations.SerializedName

data class Teams(
    @SerializedName("4")
    val teamA: TeamA,
    @SerializedName("5")
    val teamB: TeamB
)