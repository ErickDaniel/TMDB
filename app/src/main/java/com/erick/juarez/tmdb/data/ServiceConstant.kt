package com.erick.juarez.tmdb.data

import com.erick.juarez.tmdb.BuildConfig

//API KEY
const val API_QUERY = "?api_key=${BuildConfig.AUTH_BEARER_API_KEY}"

//HEADERS
const val HEADER_CONTENT_TYPE = "Content-Type: application/json;charset=utf-8"

//TIME WINDOW
const val TIME_WINDOW_DEFAULT = "week"

//QUERYS
const val QUERY_PAGE = "page"
const val QUERY_MOVIE_ID = "movie_id"

//PATH
const val PATH_NAME_MEDIA_TYPE = "media_type"
const val PATH_NAME_TIME_WINDOW = "time_window"
const val PATH_MEDIA_TYPE = "{$PATH_NAME_MEDIA_TYPE}"
const val PATH_TIME_WINDOW = "{$PATH_NAME_TIME_WINDOW}"


//PATH
const val API_VERSION_3 = "3"
const val PATH_IMAGES = "t/p/w500"
const val PATH_POPULAR = "${API_VERSION_3}/movie/popular${API_QUERY}"
const val PATH_MOVIE_DETAIL = "${API_VERSION_3}/movie/{${QUERY_MOVIE_ID}}${API_QUERY}"
const val PATH_MOVIE_MEDIA = "${API_VERSION_3}/movie/{${QUERY_MOVIE_ID}}/videos${API_QUERY}"
const val PATH_UPCOMING_CONTENT = "${API_VERSION_3}/movie/upcoming${API_QUERY}"
const val PATH_TRENDING_CONTENT = "${API_VERSION_3}/trending/${PATH_MEDIA_TYPE}/${PATH_TIME_WINDOW}${API_QUERY}"
