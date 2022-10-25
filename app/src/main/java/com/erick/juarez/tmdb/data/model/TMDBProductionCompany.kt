package com.erick.juarez.tmdb.data.model

import com.google.gson.annotations.SerializedName

data class TMDBProductionCompany (
    val id: Long,
    @SerializedName("logo_path")
    val logoPath: String? = null,
    val name: String,
    @SerializedName("origin_country")
    val originCountry: String
)