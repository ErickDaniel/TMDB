package com.erick.juarez.tmdb.domain

import com.erick.juarez.tmdb.data.TMDBRepository
import com.erick.juarez.tmdb.domain.model.Movie
import com.erick.juarez.tmdb.util.orFalse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FetchTrendingContentUseCase @Inject constructor(
    private val tmdbRepository: TMDBRepository,
    private val saveContentOnDbUseCase: SaveContentOnDbUseCase
) {

    suspend operator fun invoke(mediaType: String): List<Movie> {
        val moviesResponse = tmdbRepository.fetchTrendingContentFromApi(mediaType)

        return if (moviesResponse?.isNotEmpty().orFalse()) {
            withContext(Dispatchers.IO) {
                saveContentOnDbUseCase(moviesResponse, ContentTypes.TRENDING)
            }
            moviesResponse.orEmpty()
        } else {
            tmdbRepository.fetchTrendingMoviesFromDb()
        }
    }

}