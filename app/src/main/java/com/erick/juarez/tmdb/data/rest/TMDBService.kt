package com.erick.juarez.tmdb.data.rest

import com.erick.juarez.tmdb.data.model.TMDBMovieDetail
import com.erick.juarez.tmdb.data.model.TMDBMovieMediaResult
import com.erick.juarez.tmdb.data.model.TMDBResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TMDBService @Inject constructor(private val apiClient: TMDBApiClient) {

    suspend fun fetchPopularContent(page: Int): TMDBResponse? =
        withContext(Dispatchers.IO) {
            try {
                val response = apiClient.fetchPopularContent(page)
                response.body()
            } catch (e: Exception) {
                null
            }
        }

    suspend fun fetchTopRated(page: Int): TMDBResponse? =
        withContext(Dispatchers.IO) {
            try {
                val response = apiClient.fetchTopRatedContent(page)
                response.body()
            } catch (e: Exception) {
                null
            }

        }

    suspend fun fetchSearchQueryContent(textQuery: String, page: Int): TMDBResponse? =
        withContext(Dispatchers.IO) {
            try {
                val response = apiClient.fetchSearchQueryContent(page, textQuery)
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

    suspend fun fetchUpcomingContent(page: Int): TMDBResponse? =
        withContext(Dispatchers.IO) {
            try {
                val response = apiClient.fetchUpcomingContent(page)
                response?.body()
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }

}