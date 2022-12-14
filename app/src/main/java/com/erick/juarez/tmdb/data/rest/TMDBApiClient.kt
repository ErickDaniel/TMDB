package com.erick.juarez.tmdb.data.rest

import com.erick.juarez.tmdb.data.*
import com.erick.juarez.tmdb.data.model.TMDBMovieDetail
import com.erick.juarez.tmdb.data.model.TMDBMovieMediaResult
import com.erick.juarez.tmdb.data.model.TMDBResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface TMDBApiClient {

    @Headers(HEADER_CONTENT_TYPE)
    @GET(PATH_POPULAR)
    suspend fun fetchPopularContent(@Query(QUERY_PAGE) page: Int): Response<TMDBResponse>

    @Headers(HEADER_CONTENT_TYPE)
    @GET(PATH_MOVIE_DETAIL)
    suspend fun fetchMovieDetail(@Path(QUERY_MOVIE_ID) movieId: String): Response<TMDBMovieDetail>

    @Headers(HEADER_CONTENT_TYPE)
    @GET(PATH_MOVIE_MEDIA)
    suspend fun fetchMovieMedia(@Path(QUERY_MOVIE_ID) movieId: String): Response<TMDBMovieMediaResult>

    @Headers(HEADER_CONTENT_TYPE)
    @GET(PATH_UPCOMING_CONTENT)
    suspend fun fetchUpcomingContent(@Query(QUERY_PAGE) page: Int): Response<TMDBResponse>?

    @Headers(HEADER_CONTENT_TYPE)
    @GET(PATH_TRENDING_CONTENT)
    suspend fun fetchTrendingContent(
        @Path(PATH_NAME_MEDIA_TYPE) mediaType: String,
        @Path(PATH_NAME_TIME_WINDOW) timeWindow: String
    ): Response<TMDBResponse>?
}