package com.thedevgang.liga.data.dao

import com.google.gson.annotations.SerializedName

data class FixtureData(
    @SerializedName("results")
    val results: Integer,
    @SerializedName("fixtures")
    val fixtures: MutableList<Fixture>
)