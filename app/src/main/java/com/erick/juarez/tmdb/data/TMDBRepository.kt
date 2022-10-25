package com.erick.juarez.tmdb.data

import com.erick.juarez.tmdb.data.database.dao.TMDBMovieDao
import com.erick.juarez.tmdb.data.database.entities.TMDBMovieDetailEntity
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

    suspend fun fetchPopularContentFromApi() =
        api.fetchPopularContent()?.results?.map { it.toDomain() }


    //UPCOMING CONTENT
    suspend fun insertUpcomingContentOnDb(movies: List<TMDBUpcomingMovieEntity>) =
        tmdbMovieDao.insertUpcomingMovies(movies)

    suspend fun fetchUpcomingContentFromDB() =
        tmdbMovieDao.getUpcomingMovies().map { it.toDomain() }

    suspend fun fetchUpcomingContentFromApi() =
        api.fetchUpcomingContent()?.results?.map { it.toDomain() }


    //TRENDING CONTENT
    suspend fun insertTrendingContentOnDb(movies: List<TMDBTrendingMovieEntity>) =
        tmdbMovieDao.insertTrendingMovies(movies)

    suspend fun fetchTrendingMoviesFromDb(mediaType: String) =
        tmdbMovieDao.getTrendingMovies(mediaType).map {it.toDomain()}

    suspend fun fetchTrendingContentFromApi(mediaType: String) =
        api.fetchTrendingContent(mediaType)?.results?.map { it.toDomain() }


    //MOVIE DETAILS
    suspend fun insertMovieOnDb(movie: TMDBMovieDetailEntity) =
        tmdbMovieDao.insertMovieDetail(movie)

    suspend fun fetchMovieDetailFromApi(movieId: String) =
        api.fetchMovieDetail(movieId)?.toDomain()

    suspend fun fetchMovieDetailOnDb(movieId: String) =
        tmdbMovieDao.getMovieDetail(movieId)?.toDomain()


    suspend fun fetchMovieMedia(movieId: String) = api.fetchMovieMedia(movieId)

}