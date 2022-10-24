package com.erick.juarez.tmdb.domain

import com.erick.juarez.tmdb.data.TMDBRepository
import javax.inject.Inject

class FetchUpcomingContentUseCase @Inject constructor(private val tmdbRepository: TMDBRepository) {

    suspend operator fun invoke(page: Int) = tmdbRepository.fetchUpcomingContent(page)

}