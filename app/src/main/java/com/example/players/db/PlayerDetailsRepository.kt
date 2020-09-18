package com.example.players.db

import android.util.Log
import androidx.lifecycle.liveData
import com.example.players.api.ApiClient
import com.example.players.models.MatchDetails
import com.example.players.models.PlayerDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlayerDetailsRepository(private val dao: PlayerDetailsDAO) {
    val playerDetails = dao.getAllPlayerDetails()
    val apiRequest = ApiClient.service

    init {
        val call = apiRequest.getMatchDetails()
        call.enqueue(object : Callback<MatchDetails> {
            override fun onFailure(call: Call<MatchDetails>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<MatchDetails>, response: Response<MatchDetails>) {
                val matchDetails = response.body()
                if (playerDetails.value!!.isEmpty())
                    addPlayerToDB(matchDetails)
                else
                    updatePlayerToDB(matchDetails)
            }
        })
    }

    private fun updatePlayerToDB(matchDetails: MatchDetails?) {
        GlobalScope.launch(Dispatchers.IO) {
            deleteAll()
            addPlayerToDB(matchDetails)
        }
    }

    private fun addPlayerToDB(matchDetails: MatchDetails?) {
        val playerDetails1 = matchDetails!!.Teams.teamA.Players.player1
        playerDetails1.team = matchDetails.Teams.teamA.Name_Full
        setData(playerDetails1)
        val playerDetails2 = matchDetails!!.Teams.teamA.Players.player2
        playerDetails2.team = matchDetails.Teams.teamA.Name_Full
        setData(playerDetails2)
        val playerDetails3 = matchDetails!!.Teams.teamA.Players.player3
        playerDetails3.team = matchDetails.Teams.teamA.Name_Full
        setData(playerDetails3)
        val playerDetails4 = matchDetails!!.Teams.teamA.Players.player4
        playerDetails4.team = matchDetails.Teams.teamA.Name_Full
        setData(playerDetails4)
        val playerDetails5 = matchDetails!!.Teams.teamA.Players.player5
        playerDetails5.team = matchDetails.Teams.teamA.Name_Full
        setData(playerDetails5)
        val playerDetails6 = matchDetails!!.Teams.teamA.Players.player6
        playerDetails6.team = matchDetails.Teams.teamA.Name_Full
        setData(playerDetails6)
        val playerDetails7 = matchDetails!!.Teams.teamA.Players.player7
        playerDetails7.team = matchDetails.Teams.teamA.Name_Full
        setData(playerDetails7)
        val playerDetails8 = matchDetails!!.Teams.teamA.Players.player8
        playerDetails8.team = matchDetails.Teams.teamA.Name_Full
        setData(playerDetails8)
        val playerDetails9 = matchDetails!!.Teams.teamA.Players.player9
        playerDetails9.team = matchDetails.Teams.teamA.Name_Full
        setData(playerDetails9)
        val playerDetails10 = matchDetails!!.Teams.teamA.Players.player10
        playerDetails10.team = matchDetails.Teams.teamA.Name_Full
        setData(playerDetails10)
        val playerDetails11 = matchDetails!!.Teams.teamA.Players.player11
        playerDetails11.team = matchDetails.Teams.teamA.Name_Full
        setData(playerDetails11)

        val aplayerDetails1 = matchDetails!!.Teams.teamB.Players.player1
        aplayerDetails1.team = matchDetails.Teams.teamB.Name_Full
        setData(aplayerDetails1)
        val aplayerDetails2 = matchDetails!!.Teams.teamB.Players.player2
        aplayerDetails2.team = matchDetails.Teams.teamB.Name_Full
        setData(aplayerDetails2)
        val aplayerDetails3 = matchDetails!!.Teams.teamB.Players.player3
        aplayerDetails3.team = matchDetails.Teams.teamB.Name_Full
        setData(aplayerDetails3)
        val aplayerDetails4 = matchDetails!!.Teams.teamB.Players.player4
        aplayerDetails4.team = matchDetails.Teams.teamB.Name_Full
        setData(aplayerDetails4)
        val aplayerDetails5 = matchDetails!!.Teams.teamB.Players.player5
        aplayerDetails5.team = matchDetails.Teams.teamB.Name_Full
        setData(aplayerDetails5)
        val aplayerDetails6 = matchDetails!!.Teams.teamB.Players.player6
        aplayerDetails6.team = matchDetails.Teams.teamB.Name_Full
        setData(aplayerDetails6)
        val aplayerDetails7 = matchDetails!!.Teams.teamB.Players.player7
        aplayerDetails7.team = matchDetails.Teams.teamB.Name_Full
        setData(aplayerDetails7)
        val aplayerDetails8 = matchDetails!!.Teams.teamB.Players.player8
        aplayerDetails8.team = matchDetails.Teams.teamB.Name_Full
        setData(aplayerDetails8)
        val aplayerDetails9 = matchDetails!!.Teams.teamB.Players.player9
        aplayerDetails9.team = matchDetails.Teams.teamB.Name_Full
        setData(aplayerDetails9)
        val aplayerDetails10 = matchDetails!!.Teams.teamB.Players.player10
        aplayerDetails10.team = matchDetails.Teams.teamB.Name_Full
        setData(aplayerDetails10)
        val aplayerDetails11 = matchDetails!!.Teams.teamB.Players.player11
        aplayerDetails11.team = matchDetails.Teams.teamB.Name_Full
        setData(aplayerDetails11)
    }

    fun setData(playerDetails: PlayerDetails) {
        GlobalScope.launch(Dispatchers.IO) { insert(playerDetails) }
    }

    suspend fun insert(playerDetails: PlayerDetails): Long {
        return dao.insertPlayerDetails(playerDetails)
    }

    suspend fun deleteAll(): Int {
        return dao.deleteAll()
    }
}