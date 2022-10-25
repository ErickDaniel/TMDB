package com.erick.juarez.tmdb.domain.model

import com.erick.juarez.tmdb.data.database.entities.TMDBMovieDetailEntity
import com.erick.juarez.tmdb.data.model.TMDBGenere
import com.erick.juarez.tmdb.data.model.TMDBProductionCompany
import com.erick.juarez.tmdb.data.model.TMDBProductionCountry
import com.erick.juarez.tmdb.data.model.TMDBSpokenLanguage
import com.erick.juarez.tmdb.data.model.TMDBMovieDetail

data class MovieDetail(
    var id: Long? = 0L,
    var adult: Boolean? = false,
    var backdropPath: String? = "",
    var budget: Long? = 0L,
    var genres: List<TMDBGenere>? = emptyList(),
    var homepage: String? = "",
    var imdbID: String? = "",
    var originalLanguage: String? = "",
    var originalTitle: String? = "",
    var overview: String? = "",
    var popularity: Double? = 0.0,
    var posterPath: String? = "",
    var productionCompanies: List<TMDBProductionCompany>? = emptyList(),
    var productionCountries: List<TMDBProductionCountry>? = emptyList(),
    var releaseDate: String? = "",
    var revenue: Long? = 0L,
    var runtime: Long? = 0L,
    var spokenLanguages: List<TMDBSpokenLanguage>? = emptyList(),
    var status: String? = "",
    var tagline: String? = "",
    var title: String? = "",
    var video: Boolean? = false,
    var voteAverage: Double? = 0.0,
    var voteCount: Long? = 0L
)

fun TMDBMovieDetailEntity.toDomain() =
    MovieDetail(
        id,
        adult,
        backdropPath,
        budget,
        genres,
        homepage,
        imdbID,
        originalLanguage,
        originalTitle,
        overview,
        popularity,
        posterPath,
        productionCompanies,
        productionCountries,
        releaseDate,
        revenue,
        runtime,
        spokenLanguages,
        status,
        tagline,
        title,
        video,
        voteAverage,
        voteCount
    )

fun TMDBMovieDetail.toDomain() =
    MovieDetail(
        id,
        adult,
        backdropPath,
        budget,
        genres,
        homepage,
        imdbID,
        originalLanguage,
        originalTitle,
        overview,
        popularity,
        posterPath,
        productionCompanies,
        productionCountries,
        releaseDate,
        revenue,
        runtime,
        spokenLanguages,
        status,
        tagline,
        title,
        video,
        voteAverage,
        voteCount
    )