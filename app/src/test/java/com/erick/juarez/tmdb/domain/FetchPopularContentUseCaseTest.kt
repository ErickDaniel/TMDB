package com.erick.juarez.tmdb.domain

import com.erick.juarez.tmdb.data.TMDBRepository
import com.erick.juarez.tmdb.domain.model.Movie
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class FetchPopularContentUseCaseTest {

    @RelaxedMockK
    private lateinit var tmdbRepository: TMDBRepository

    @RelaxedMockK
    private lateinit var saveContentOnDbUseCase: SaveContentOnDbUseCase

    lateinit var fetchPopularContentUseCase: FetchPopularContentUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        fetchPopularContentUseCase =
            FetchPopularContentUseCase(tmdbRepository, saveContentOnDbUseCase)
    }

    @Test
    fun `when get popular content from api is called, then get movies`() = runBlocking {
        //Given
        coEvery { tmdbRepository.fetchPopularContentFromApi() } returns filledList

        //When
        val response = fetchPopularContentUseCase()

        //Then
        coVerify(exactly = 1) { tmdbRepository.fetchPopularContentFromApi() }
        assert(filledList == response)
    }

    @Test
    fun `when get popular content from api is called, then get movies from DB`() = runBlocking {
        //Given
        coEvery { tmdbRepository.fetchPopularContentFromApi() } returns emptyList()
        coEvery { tmdbRepository.fetchPopularContentFromDB() } returns filledList

        //When
        val response = fetchPopularContentUseCase()

        //Then
        coVerify(exactly = 1) { tmdbRepository.fetchPopularContentFromDB() }
        assert(response == filledList)
    }

    val filledList = listOf(
        Movie(
            adult = false,
                backdropPath = "",
                id = "",
                overview = "",
                posterPath = "",
                releaseDate = "",
                title = "",
                voteAverage = 0.0,
                voteCount = 0,
                mediaType = "",
        )
    )
}