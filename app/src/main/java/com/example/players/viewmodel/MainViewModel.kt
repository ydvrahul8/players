package com.example.players.viewmodel

import androidx.lifecycle.ViewModel
import com.example.players.db.PlayerDetailsRepository
import com.example.players.models.PlayerDetails

class MainViewModel(private val repository: PlayerDetailsRepository) : ViewModel() {
    val playerDetails = repository.playerDetails
}