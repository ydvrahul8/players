package com.example.players.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.players.R
import com.example.players.adapters.ViewPagerAdapter
import com.example.players.db.PlayerDetailsDatabase
import com.example.players.db.PlayerDetailsRepository
import com.example.players.models.PlayerDetails
import com.example.players.viewmodel.MainViewModel
import com.example.players.viewmodel.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dao = PlayerDetailsDatabase.getInstance(applicationContext).playerDetailsDAO
        val repository = PlayerDetailsRepository(dao)
        val factory =
            MainViewModelFactory(repository)
        mainViewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
        teamsObserver()
    }

    private fun teamsObserver() {
        mainViewModel.playerDetails.observe(this, Observer {
            segregateData(it)
        })
    }

    private fun segregateData(it: List<PlayerDetails>?) {
        val teamA = ArrayList<PlayerDetails>()
        val teamB = ArrayList<PlayerDetails>()
        val teamAName = it!![0].team
        it!!.forEach { players ->
            if (players.team.equals(teamAName, true))
                teamA.add(players)
            else
                teamB.add(players)
        }
        setUpViewPager(teamA,teamB)
    }

    private fun setUpViewPager(
        teamA: ArrayList<PlayerDetails>,
        teamB: ArrayList<PlayerDetails>
    ) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(TeamAFragment.newInstance("",teamA), teamA[0].team!!)
        adapter.addFragment(TeamBFragment.newInstance("",teamB), teamB[0].team!!)
        viewpager.adapter = adapter
    }
}