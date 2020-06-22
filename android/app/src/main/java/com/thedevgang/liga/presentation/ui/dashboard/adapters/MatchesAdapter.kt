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
import com.thedevgang.liga.data.dao.Match

class MatchesAdapter : RecyclerView.Adapter<MatchesAdapter.ViewHolder> {
    var matches : MutableList<Match> = ArrayList()
    lateinit var context : Context

    constructor(matches : MutableList<Match>, context: Context) {
        this.matches = matches
        this.context = context
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivHomeTeamLogo = view.findViewById<ImageView>(R.id.iv_hometeam_logo)
        val homeTeamName = view.findViewById<TextView>(R.id.txt_hometeam_name)
        val homeTeamCity = view.findViewById<TextView>(R.id.txt_hometeam_city)

        val ivVisitorTeamLogo = view.findViewById<ImageView>(R.id.iv_visitorteam_logo)
        val visitorTeamName = view.findViewById<TextView>(R.id.txt_visitorteam_name)
        val visitorTeamCity = view.findViewById<TextView>(R.id.txt_visitorteam_city)

        val goalBoard = view.findViewById<TextView>(R.id.txt_goal_board)

        val btnLineups = view.findViewById<Button>(R.id.btn_lineups)
        val btnGoals = view.findViewById<Button>(R.id.btn_goals)

        fun bind(item: Match, context: Context) {
            homeTeamName.text = item.homeTeamName
            homeTeamCity.text = item.homeTeamCity

            visitorTeamName.text = item.visitorTeamName
            visitorTeamCity.text = item.visitorTeamCity

            goalBoard.text = String.format("%s : %s", item.homeTeamGoals, item.visitorTeamGoals)

            Glide.with(itemView).load(item.homeTeamLogo).apply(RequestOptions().override(200, 200)).into(ivHomeTeamLogo)
            Glide.with(itemView).load(item.visitorTeamLogo).apply(RequestOptions().override(200, 200)).into(ivVisitorTeamLogo)
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
        val item : Match = matches[position]
        holder.bind(item, context)
    }
}