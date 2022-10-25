package com.erick.juarez.tmdb.domain

import com.erick.juarez.tmdb.data.TMDBRepository
import com.erick.juarez.tmdb.data.database.entities.toDatabase
import com.erick.juarez.tmdb.domain.model.MovieDetail
import javax.inject.Inject

class SaveMovieDetailOnDbUseCase @Inject constructor(
    private val tmdbRepository: TMDBRepository
) {

    suspend operator fun invoke(movie: MovieDetail) =
        tmdbRepository.insertMovieOnDb(movie.toDatabase())

}