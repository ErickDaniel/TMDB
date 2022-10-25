package com.erick.juarez.tmdb.domain

import com.erick.juarez.tmdb.data.TMDBRepository
import com.erick.juarez.tmdb.data.model.TMDBMovieMediaResult
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class FetchMovieMediaUseCaseTest {

    @RelaxedMockK
    private lateinit var tmdbRepository: TMDBRepository

    lateinit var fetchMovieMediaUseCase: FetchMovieMediaUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        fetchMovieMediaUseCase =
            FetchMovieMediaUseCase(tmdbRepository)
    }

    @Test
    fun `when api does not return nothing get null response`() = runBlocking {
        //Given
        coEvery { tmdbRepository.fetchMovieMedia("717728") } returns null

        //When
        val response = fetchMovieMediaUseCase("717728")

        //Then
        assert(response == null)
    }

    @Test
    fun `when api gets 201 then get a movie media`() = runBlocking {
        //Given
        coEvery { tmdbRepository.fetchMovieMedia("717728") } returns TMDBMovieMediaResult()

        //When
        val response = fetchMovieMediaUseCase("717728")

        //Then
        assert(response is TMDBMovieMediaResult)
    }


}