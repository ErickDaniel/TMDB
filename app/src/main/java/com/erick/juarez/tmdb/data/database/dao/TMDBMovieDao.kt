package com.erick.juarez.tmdb.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.erick.juarez.tmdb.data.database.MOVIE_DETAIL_TABLE
import com.erick.juarez.tmdb.data.database.POPULAR_MOVIE_TABLE
import com.erick.juarez.tmdb.data.database.TRENDING_MOVIE_TABLE
import com.erick.juarez.tmdb.data.database.UPCOMING_MOVIE_TABLE
import com.erick.juarez.tmdb.data.database.entities.TMDBMovieDetailEntity
import com.erick.juarez.tmdb.data.database.entities.TMDBPopularMovieEntity
import com.erick.juarez.tmdb.data.database.entities.TMDBTrendingMovieEntity
import com.erick.juarez.tmdb.data.database.entities.TMDBUpcomingMovieEntity

@Dao
interface TMDBMovieDao {

    //POPULAR CONTENT
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPopularMovies(tmdbPopularMovieEntity: List<TMDBPopularMovieEntity>)

    @Query("SELECT * FROM $POPULAR_MOVIE_TABLE")
    suspend fun getPopularMovies(): List<TMDBPopularMovieEntity>

    //UPCOMING CONTENT
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUpcomingMovies(tmdbUpcomingMovieEntity: List<TMDBUpcomingMovieEntity>)

    @Query("SELECT * FROM $UPCOMING_MOVIE_TABLE")
    suspend fun getUpcomingMovies(): List<TMDBUpcomingMovieEntity>

    //TRENDING CONTENT
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrendingMovies(tmdbTrendingMovieEntity: List<TMDBTrendingMovieEntity>)

    @Query("SELECT * FROM $TRENDING_MOVIE_TABLE WHERE mediaType=:mediaType")
    suspend fun getTrendingMovies(mediaType: String): List<TMDBTrendingMovieEntity>

    //MOVIE DETAIL
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovieDetail(movieDetail: TMDBMovieDetailEntity)

    @Query("SELECT * FROM $MOVIE_DETAIL_TABLE WHERE id=:movieId")
    suspend fun getMovieDetail(movieId: String): TMDBMovieDetailEntity?

}