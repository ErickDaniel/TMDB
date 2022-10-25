package com.erick.juarez.tmdb.domain

import com.erick.juarez.tmdb.data.TMDBRepository
import com.erick.juarez.tmdb.domain.model.MovieDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FetchMovieDetailUseCase @Inject constructor(
    private val tmdbRepository: TMDBRepository,
    private val saveMovieDetailOnDbUseCase: SaveMovieDetailOnDbUseCase
) {

    suspend operator fun invoke(movieId: String): MovieDetail? {
        val moviesResponse = tmdbRepository.fetchMovieDetailFromApi(movieId)

        return if(moviesResponse != null){
            withContext(Dispatchers.IO){
                saveMovieDetailOnDbUseCase(moviesResponse)
                moviesResponse
            }
        } else {
            tmdbRepository.fetchMovieDetailOnDb(movieId)
        }
    }

}