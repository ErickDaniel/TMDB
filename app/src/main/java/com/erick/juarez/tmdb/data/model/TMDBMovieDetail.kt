package com.erick.juarez.tmdb.data.model

import com.google.gson.annotations.SerializedName

data class TMDBMovieDetail (
    val adult: Boolean = false,

    @SerializedName("backdrop_path")
    val backdropPath: String = "",

    val budget: Long = 0L,
    val genres: List<TMDBGenere> = emptyList(),
    val homepage: String = "",
    val id: Long = 0L,

    @SerializedName("imdb_id")
    val imdbID: String = "",

    @SerializedName("original_language")
    val originalLanguage: String = "",

    @SerializedName("original_title")
    val originalTitle: String = "",

    val overview: String = "",
    val popularity: Double = 0.0,

    @SerializedName("poster_path")
    val posterPath: String? = "",

    @SerializedName("production_companies")
    val productionCompanies: List<TMDBProductionCompany> = emptyList(),

    @SerializedName("production_countries")
    val productionCountries: List<TMDBProductionCountry> = emptyList(),

    @SerializedName("release_date")
    val releaseDate: String = "",

    val revenue: Long = 0L,
    val runtime: Long = 0L,

    @SerializedName("spoken_languages")
    val spokenLanguages: List<TMDBSpokenLanguage> = emptyList(),

    val status: String = "",
    val tagline: String = "",
    val title: String = "",
    val video: Boolean = false,

    @SerializedName("vote_average")
    val voteAverage: Double = 0.0,

    @SerializedName("vote_count")
    val voteCount: Long = 0L
)