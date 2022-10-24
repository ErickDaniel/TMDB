package com.erick.juarez.tmdb.data

import com.erick.juarez.tmdb.BuildConfig

//API KEY
const val API_QUERY = "?api_key=${BuildConfig.AUTH_BEARER_API_KEY}"

//HEADERS
const val HEADER_CONTENT_TYPE = "Content-Type: application/json;charset=utf-8"

//MEDIA TYPES
const val MEDIA_TYPE_ALL = "all"
const val MEDIA_TYPE_MOVIE = "movie"
const val MEDIA_TYPE_TV = "tv"
const val MEDIA_TYPE_PERSON = "person"

//QUERYS
const val QUERY_PAGE = "page"
const val QUERY_MOVIE_ID = "movie_id"
const val QUERY_MEDIA_TYPE = "media_type"

//PATH
const val API_VERSION_3 = "3"
const val PATH_IMAGES = "t/p/w500"
const val PATH_POPULAR = "${API_VERSION_3}/movie/popular${API_QUERY}"
const val PATH_MOVIE_DETAIL = "${API_VERSION_3}/movie/{${QUERY_MOVIE_ID}}${API_QUERY}"
const val PATH_MOVIE_MEDIA = "${API_VERSION_3}/movie/{${QUERY_MOVIE_ID}}/videos${API_QUERY}"
const val PATH_UPCOMING_CONTENT = "${API_VERSION_3}/movie/upcoming${API_QUERY}"
const val PATH_TRENDING_CONTENT = "${API_VERSION_3}/trending/${QUERY_MEDIA_TYPE}${API_QUERY}"
