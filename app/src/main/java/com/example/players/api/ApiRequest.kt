package com.example.players.api

import com.example.players.models.MatchDetails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRequest {
    @GET("sifeeds/cricket/live/json/nzin01312019187360.json")
    fun getMatchDetails(): Call<MatchDetails>

}
