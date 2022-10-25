package com.erick.juarez.tmdb.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.erick.juarez.tmdb.data.database.POPULAR_MOVIE_TABLE
import com.erick.juarez.tmdb.domain.model.Movie

@Entity(tableName = POPULAR_MOVIE_TABLE)
data class TMDBPopularMovieEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") var id: String = "",
    @ColumnInfo(name = "adult") var adult: Boolean = false,
    @ColumnInfo(name = "backdropPath") var backdropPath: String = "",
    @ColumnInfo(name = "overview") var overview: String = "",
    @ColumnInfo(name = "posterPath") var posterPath: String? = "",
    @ColumnInfo(name = "releaseDate") var releaseDate: String = "",
    @ColumnInfo(name = "title") var title: String = "",
    @ColumnInfo(name = "voteAverage") var voteAverage: Double = 0.0,
    @ColumnInfo(name = "voteCount") var voteCount: Int = 0
)

fun Movie.toDatabasePopular() = TMDBPopularMovieEntity(
    id,
    adult,
    backdropPath,
    overview,
    posterPath,
    releaseDate,
    title,
    voteAverage,
    voteCount
)