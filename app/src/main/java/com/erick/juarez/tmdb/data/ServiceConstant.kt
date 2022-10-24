package com.erick.juarez.tmdb.data

import com.erick.juarez.tmdb.BuildConfig

//API KEY
const val API_QUERY = "?api_key=${BuildConfig.AUTH_BEARER_API_KEY}"

//HEADERS
const val HEADER_CONTENT_TYPE = "Content-Type: application/json;charset=utf-8"


//QUERYS
const val QUERY_PAGE = "page"
const val QUERY_SEARCH = "query"
const val QUERY_MOVIE_ID = "movie_id"

//PATH
const val API_VERSION_3 = "3"
const val API_VERSION_4 = "4"
const val PATH_IMAGES = "t/p/w500"
const val PATH_POPULAR = "${API_VERSION_3}/movie/popular${API_QUERY}"
const val PATH_TOP_RATED = "${API_VERSION_3}/movie/top_rated${API_QUERY}"
const val PATH_SEARCH = "${API_VERSION_3}/search/movie${API_QUERY}&include_adult=false"
const val PATH_MOVIE_DETAIL = "${API_VERSION_3}/movie/{${QUERY_MOVIE_ID}}${API_QUERY}"
const val PATH_MOVIE_MEDIA = "${API_VERSION_3}/movie/{${QUERY_MOVIE_ID}}/videos${API_QUERY}"
