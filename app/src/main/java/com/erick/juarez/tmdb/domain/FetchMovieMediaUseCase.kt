package com.erick.juarez.tmdb.domain

import com.erick.juarez.tmdb.data.TMDBRepository
import javax.inject.Inject

class FetchMovieMediaUseCase @Inject constructor(
    private val tmdbRepository: TMDBRepository
) {

    suspend operator fun invoke(movieId: String) = tmdbRepository.fetchMovieMedia(movieId)

}