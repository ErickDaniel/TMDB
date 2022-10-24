package com.erick.juarez.tmdb.domain

import com.erick.juarez.tmdb.data.TMDBRepository
import javax.inject.Inject

class FetchPopularContentUseCase @Inject constructor(private val tmdbRepository: TMDBRepository) {

    suspend operator fun invoke(
        page: Int
    ) = tmdbRepository.fetchPopularContent(page)

}