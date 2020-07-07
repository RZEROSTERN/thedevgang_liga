package com.thedevgang.liga.presentation.ui.dashboard.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.thedevgang.liga.R
import com.thedevgang.liga.data.dao.Fixture

class MatchesAdapter : RecyclerView.Adapter<MatchesAdapter.ViewHolder> {
    var matches : MutableList<Fixture> = ArrayList()
    lateinit var context : Context

    constructor(matches : MutableList<Fixture>, context: Context) {
        this.matches = matches
        this.context = context
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivHomeTeamLogo = view.findViewById<ImageView>(R.id.iv_hometeam_logo)
        val homeTeamName = view.findViewById<TextView>(R.id.txt_hometeam_name)
        val homeTeamCity = view.findViewById<TextView>(R.id.txt_hometeam_city)

        val ivAwayTeamLogo = view.findViewById<ImageView>(R.id.iv_visitorteam_logo)
        val awayTeamName = view.findViewById<TextView>(R.id.txt_visitorteam_name)
        val awayTeamCity = view.findViewById<TextView>(R.id.txt_visitorteam_city)

        val goalBoard = view.findViewById<TextView>(R.id.txt_goal_board)

        val btnLineups = view.findViewById<Button>(R.id.btn_lineups)
        val btnGoals = view.findViewById<Button>(R.id.btn_goals)

        fun bind(item: Fixture, context: Context) {
            homeTeamName.text = item.home_team.team_name
            homeTeamCity.text = ""

            awayTeamName.text = item.away_team.team_name
            awayTeamCity.text = ""

            goalBoard.text = String.format("%s : %s", item.goalsHomeTeam, item.goalsAwayTeam)

            Glide.with(itemView).load(item.home_team.logo).apply(RequestOptions().override(200, 200)).into(ivHomeTeamLogo)
            Glide.with(itemView).load(item.away_team.logo).apply(RequestOptions().override(200, 200)).into(ivAwayTeamLogo)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.match_item, parent, false))
    }

    override fun getItemCount(): Int {
        return matches.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item : Fixture = matches[position]
        holder.bind(item, context)
    }
}