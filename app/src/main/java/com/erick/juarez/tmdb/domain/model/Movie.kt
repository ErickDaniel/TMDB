package com.erick.juarez.tmdb.domain.model

import com.erick.juarez.tmdb.data.database.entities.TMDBPopularMovieEntity
import com.erick.juarez.tmdb.data.database.entities.TMDBTrendingMovieEntity
import com.erick.juarez.tmdb.data.database.entities.TMDBUpcomingMovieEntity
import com.erick.juarez.tmdb.data.model.TMDBMovie

data class Movie(
    var adult: Boolean = false,
    var backdropPath: String = "",
    var id: String = "",
    var overview: String = "",
    var posterPath: String? = "",
    var releaseDate: String = "",
    var title: String = "",
    var voteAverage: Double = 0.0,
    var voteCount: Int = 0
)

fun TMDBMovie.toDomain() =
    Movie(
        adult,
        backdropPath,
        id,
        overview,
        posterPath,
        releaseDate,
        title,
        voteAverage,
        voteCount
    )

fun TMDBPopularMovieEntity.toDomain() =
    Movie(
        adult,
        backdropPath,
        id,
        overview,
        posterPath,
        releaseDate,
        title,
        voteAverage,
        voteCount
    )

fun TMDBUpcomingMovieEntity.toDomain() =
    Movie(
        adult,
        backdropPath,
        id,
        overview,
        posterPath,
        releaseDate,
        title,
        voteAverage,
        voteCount
    )

fun TMDBTrendingMovieEntity.toDomain() =
    Movie(
        adult,
        backdropPath,
        id,
        overview,
        posterPath,
        releaseDate,
        title,
        voteAverage,
        voteCount
    )