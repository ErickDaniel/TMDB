package com.erick.juarez.tmdb.domain

import com.erick.juarez.tmdb.data.TMDBRepository
import com.erick.juarez.tmdb.data.database.entities.toDatabasePopular
import com.erick.juarez.tmdb.data.database.entities.toDatabaseTrending
import com.erick.juarez.tmdb.data.database.entities.toDatabaseUpcoming
import com.erick.juarez.tmdb.domain.ContentTypes.*
import com.erick.juarez.tmdb.domain.model.Movie
import javax.inject.Inject

class SaveContentOnDbUseCase @Inject constructor(
    private val tmdbRepository: TMDBRepository
) {

    suspend operator fun invoke(movies: List<Movie>?, contentType: ContentTypes) {
        if(movies != null) {
            when (contentType) {
                POPULAR -> {
                    tmdbRepository.insertPopularContentOnDb(movies.map { it.toDatabasePopular() })
                }
                UPCOMING -> {
                    tmdbRepository.insertUpcomingContentOnDb(movies.map { it.toDatabaseUpcoming() })
                }
                TRENDING -> {
                    tmdbRepository.insertTrendingContentOnDb(movies.map { it.toDatabaseTrending() })
                }
            }
        }
    }

}