package com.erick.juarez.tmdb.data.model

import com.google.gson.annotations.SerializedName

data class TMDBProductionCountry (
    @SerializedName("iso_3166_1")
    val iso3166_1: String,
    val name: String
)