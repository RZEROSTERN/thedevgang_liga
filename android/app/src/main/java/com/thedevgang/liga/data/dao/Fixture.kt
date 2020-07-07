package com.thedevgang.liga.data.dao

import com.google.gson.annotations.SerializedName

data class Fixture (
    @SerializedName("fixture_id")
    val fixture_id: Int,
    @SerializedName("league_id")
    val league_id: Int,
    @SerializedName("league")
    val league: League,
    @SerializedName("event_date")
    val event_date: String,
    @SerializedName("round")
    val round: String,
    @SerializedName("homeTeam")
    val home_team: Team,
    @SerializedName("awayTeam")
    val away_team: Team,
    @SerializedName("goalsHomeTeam")
    val goalsHomeTeam: Int,
    @SerializedName("goalsAwayTeam")
    val goalsAwayTeam: Int
)