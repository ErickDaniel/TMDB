package com.erick.juarez.tmdb.domain

import com.erick.juarez.tmdb.data.TMDBRepository
import com.erick.juarez.tmdb.domain.model.Movie
import com.erick.juarez.tmdb.util.orFalse
import javax.inject.Inject

class FetchPopularContentUseCase @Inject constructor(
    private val tmdbRepository: TMDBRepository,
    private val saveContentOnDbUseCase: SaveContentOnDbUseCase
) {

    suspend operator fun invoke(page: Int): List<Movie> {
        val moviesResponse = tmdbRepository.fetchPopularContentFromApi(page)

        return if (moviesResponse?.isNotEmpty().orFalse()) {
            saveContentOnDbUseCase(moviesResponse, ContentTypes.POPULAR)
            moviesResponse.orEmpty()
        } else {
            tmdbRepository.fetchPopularContentFromDB()
        }


    }

}