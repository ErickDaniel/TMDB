package com.erick.juarez.tmdb.data

import com.erick.juarez.tmdb.data.rest.TMDBService
import javax.inject.Inject

class TMDBRepository @Inject constructor(val api: TMDBService) {

    suspend fun fetchPopularContent(page: Int) = api.fetchPopularContent(page)

    suspend fun fetchTopRated(page: Int) = api.fetchTopRated(page)

    suspend fun fetchSearchQueryContent(textQuery: String, page: Int) =
        api.fetchSearchQueryContent(textQuery, page)

    suspend fun fetchMovieDetail(movieId: String) = api.fetchMovieDetail(movieId)

    suspend fun fetchMovieMedia(movieId: String) = api.fetchMovieMedia(movieId)

}