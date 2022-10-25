package com.erick.juarez.tmdb.data.rest

import com.erick.juarez.tmdb.data.TIME_WINDOW_DEFAULT
import com.erick.juarez.tmdb.data.model.TMDBMovieDetail
import com.erick.juarez.tmdb.data.model.TMDBMovieMediaResult
import com.erick.juarez.tmdb.data.model.TMDBResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TMDBService @Inject constructor(private val apiClient: TMDBApiClient) {

    suspend fun fetchPopularContent(): TMDBResponse? =
        withContext(Dispatchers.IO) {
            try {
                val response = apiClient.fetchPopularContent(1)
                response.body()
            } catch (e: Exception) {
                null
            }
        }

    suspend fun fetchMovieDetail(movieId: String): TMDBMovieDetail? =
        withContext(Dispatchers.IO) {
            try {
                val response = apiClient.fetchMovieDetail(movieId)
                response.body()
            } catch (e: Exception) {
                null
            }
        }

    suspend fun fetchMovieMedia(movieId: String): TMDBMovieMediaResult? =
        withContext(Dispatchers.IO) {
            try {
                val response = apiClient.fetchMovieMedia(movieId)
                response.body()
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }

    suspend fun fetchUpcomingContent(): TMDBResponse? =
        withContext(Dispatchers.IO) {
            try {
                val response = apiClient.fetchUpcomingContent(1)
                response?.body()
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }

    suspend fun fetchTrendingContent(mediaType: String): TMDBResponse? =
        withContext(Dispatchers.IO) {
            try {
                val response = apiClient.fetchTrendingContent(mediaType, TIME_WINDOW_DEFAULT)
                response?.body()
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }

}