package com.erick.juarez.tmdb.domain

import com.erick.juarez.tmdb.data.TMDBRepository
import com.erick.juarez.tmdb.domain.model.MovieDetail
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class FetchMovieDetailUseCaseTest {

    @RelaxedMockK
    private lateinit var tmdbRepository: TMDBRepository
    @RelaxedMockK
    private lateinit var saveMovieDetailOnDbUseCase: SaveMovieDetailOnDbUseCase

    lateinit var fetchMovieDetailUseCase: FetchMovieDetailUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        fetchMovieDetailUseCase =
            FetchMovieDetailUseCase(tmdbRepository, saveMovieDetailOnDbUseCase)
    }

    @Test
    fun `when api does not return nothing get movie from DB`() = runBlocking {
        //Given
        coEvery { tmdbRepository.fetchMovieDetailFromApi("717728") } returns MovieDetail()

        //When
        fetchMovieDetailUseCase("717728")

        //Then
        coVerify(exactly = 1) { tmdbRepository.fetchMovieDetailFromApi("717728") }
    }

    @Test
    fun `when database gets called, movie detail is not null`() = runBlocking {
        //Given
        coEvery { tmdbRepository.fetchMovieDetailOnDb("717728") } returns null

        //When
        val response = fetchMovieDetailUseCase("717728")

        //Then
        assert(response != null)
    }

}