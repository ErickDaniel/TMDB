package com.erick.juarez.tmdb.data

import com.erick.juarez.tmdb.data.database.dao.TMDBMovieDao
import com.erick.juarez.tmdb.data.database.entities.TMDBPopularMovieEntity
import com.erick.juarez.tmdb.data.database.entities.TMDBTrendingMovieEntity
import com.erick.juarez.tmdb.data.database.entities.TMDBUpcomingMovieEntity
import com.erick.juarez.tmdb.data.rest.TMDBService
import com.erick.juarez.tmdb.domain.model.toDomain
import javax.inject.Inject

class TMDBRepository @Inject constructor(
    private val api: TMDBService,
    private val tmdbMovieDao: TMDBMovieDao
) {

    //POPULAR CONTENT
    suspend fun insertPopularContentOnDb(movies: List<TMDBPopularMovieEntity>) =
        tmdbMovieDao.insertPopularMovies(movies)

    suspend fun fetchPopularContentFromDB() =
        tmdbMovieDao.getPopularMovies().map { it.toDomain() }

    suspend fun fetchPopularContentFromApi(page: Int) =
        api.fetchPopularContent(page)?.results?.map { it.toDomain() }


    //UPCOMING CONTENT
    suspend fun insertUpcomingContentOnDb(movies: List<TMDBUpcomingMovieEntity>) =
        tmdbMovieDao.insertUpcomingMovies(movies)

    suspend fun fetchUpcomingContentFromDB() =
        tmdbMovieDao.getUpcomingMovies().map { it.toDomain() }

    suspend fun fetchUpcomingContentFromApi(page: Int) =
        api.fetchUpcomingContent(page)?.results?.map { it.toDomain() }


    //TRENDING CONTENT
    suspend fun insertTrendingContentOnDb(movies: List<TMDBTrendingMovieEntity>) =
        tmdbMovieDao.insertTrendingMovies(movies)

    suspend fun fetchTrendingMoviesFromDb() =
        tmdbMovieDao.getTrendingMovies().map {it.toDomain()}

    suspend fun fetchTrendingContentFromApi(page: Int, mediaType: String) =
        api.fetchTrendingContent(page, mediaType)?.results?.map { it.toDomain() }


    //MOVIE DETAILS
    suspend fun fetchMovieDetail(movieId: String) = api.fetchMovieDetail(movieId)

    suspend fun fetchMovieMedia(movieId: String) = api.fetchMovieMedia(movieId)

}