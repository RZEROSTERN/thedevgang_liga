package com.thedevgang.liga.data.dao

import com.google.gson.annotations.SerializedName

data class League(
    @SerializedName("name")
    val name: String,

    @SerializedName("country")
    val country: String,

    @SerializedName("logo")
    val logo: String,

    @SerializedName("flag")
    val flag: String
)