package com.thedevgang.liga.data.dao

import com.google.gson.annotations.SerializedName

data class Team (
    @SerializedName("team_id")
    val team_id: Integer,
    @SerializedName("team_name")
    val team_name: String,
    @SerializedName("logo")
    val logo: String
)