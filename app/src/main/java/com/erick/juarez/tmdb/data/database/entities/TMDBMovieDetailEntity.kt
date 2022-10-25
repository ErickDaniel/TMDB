package com.erick.juarez.tmdb.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.erick.juarez.tmdb.data.database.MOVIE_DETAIL_TABLE
import com.erick.juarez.tmdb.data.model.TMDBGenere
import com.erick.juarez.tmdb.data.model.TMDBProductionCompany
import com.erick.juarez.tmdb.data.model.TMDBProductionCountry
import com.erick.juarez.tmdb.data.model.TMDBSpokenLanguage
import com.erick.juarez.tmdb.domain.model.MovieDetail

@Entity(tableName = MOVIE_DETAIL_TABLE)
data class TMDBMovieDetailEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") var id: Long? = 0L,
    @ColumnInfo(name = "adult") var adult: Boolean? = false,
    @ColumnInfo(name = "backdropPath") var backdropPath: String? = "",
    @ColumnInfo(name = "budget") var budget: Long? = 0L,
    @ColumnInfo(name = "genres") var genres: List<TMDBGenere>? = emptyList(),
    @ColumnInfo(name = "homepage") var homepage: String? = "",
    @ColumnInfo(name = "imdbID") var imdbID: String? = "",
    @ColumnInfo(name = "originalLanguage") var originalLanguage: String? = "",
    @ColumnInfo(name = "originalTitle") var originalTitle: String? = "",
    @ColumnInfo(name = "overview") var overview: String? = "",
    @ColumnInfo(name = "popularity") var popularity: Double? = 0.0,
    @ColumnInfo(name = "posterPath") var posterPath: String? = "",
    @ColumnInfo(name = "productionCompanies") var productionCompanies: List<TMDBProductionCompany>? = emptyList(),
    @ColumnInfo(name = "productionCountries") var productionCountries: List<TMDBProductionCountry>? = emptyList(),
    @ColumnInfo(name = "releaseDate") var releaseDate: String? = "",
    @ColumnInfo(name = "revenue") var revenue: Long? = 0L,
    @ColumnInfo(name = "runtime") var runtime: Long? = 0L,
    @ColumnInfo(name = "spokenLanguages") var spokenLanguages: List<TMDBSpokenLanguage>? = emptyList(),
    @ColumnInfo(name = "status") var status: String? = "",
    @ColumnInfo(name = "tagline") var tagline: String? = "",
    @ColumnInfo(name = "title") var title: String? = "",
    @ColumnInfo(name = "video") var video: Boolean? = false,
    @ColumnInfo(name = "voteAverage") var voteAverage: Double? = 0.0,
    @ColumnInfo(name = "voteCount") var voteCount: Long? = 0L
)

fun MovieDetail.toDatabase() =
    TMDBMovieDetailEntity(
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