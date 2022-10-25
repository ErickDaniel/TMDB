package com.erick.juarez.tmdb.data.model

import com.google.gson.annotations.SerializedName

data class TMDBSpokenLanguage (
    @SerializedName("iso_639_1")
    val iso639_1: String,
    val name: String
)