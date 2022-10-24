package com.erick.juarez.tmdb.domain

import com.erick.juarez.tmdb.data.TMDBRepository
import com.erick.juarez.tmdb.data.model.TMDBResponse
import javax.inject.Inject

class FetchPopularContentUseCase @Inject constructor(private val tmdbRepository: TMDBRepository):
    UseCase<TMDBResponse?> {

    override suspend fun invoke() = tmdbRepository.fetchPopularContent(1)

}