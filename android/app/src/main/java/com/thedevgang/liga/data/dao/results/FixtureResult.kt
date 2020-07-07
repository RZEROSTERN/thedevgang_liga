package com.thedevgang.liga.data.dao.results

import com.google.gson.annotations.SerializedName
import com.thedevgang.liga.data.dao.FixtureData

data class FixtureResult (
    @SerializedName("api")
    val fixtureData: FixtureData
)