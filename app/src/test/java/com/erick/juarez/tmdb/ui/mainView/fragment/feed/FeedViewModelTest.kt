package com.erick.juarez.tmdb.ui.mainView.fragment.feed

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.erick.juarez.tmdb.domain.FetchPopularContentUseCase
import com.erick.juarez.tmdb.domain.FetchTrendingContentUseCase
import com.erick.juarez.tmdb.domain.FetchUpcomingContentUseCase
import com.erick.juarez.tmdb.domain.model.Movie
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
@ExperimentalCoroutinesApi
class FeedViewModelTest {
    @RelaxedMockK
    private lateinit var fetchUpcomingContentUseCase: FetchUpcomingContentUseCase

    @RelaxedMockK
    private lateinit var fetchPopularContentUseCase: FetchPopularContentUseCase

    @RelaxedMockK
    private lateinit var fetchTrendingContentUseCase: FetchTrendingContentUseCase

    private lateinit var feedViewModel: FeedViewModel

    @RelaxedMockK
    lateinit var observer: Observer<FeedActions>

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        feedViewModel = FeedViewModel(
            fetchUpcomingContentUseCase,
            fetchPopularContentUseCase,
            fetchTrendingContentUseCase
        )
        Dispatchers.setMain(Dispatchers.Unconfined)
        feedViewModel.feedActions.observeForever(observer)
    }

    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun `when viewModel is created at the first time, get list from api`() = runTest {
        //Given
        coEvery { fetchUpcomingContentUseCase() } returns filledList

        //When
        feedViewModel.onCreate()

        //Then
        assert(
            feedViewModel.feedActions.value is FeedActions.FetchTrendingContentSuccess ||
                    feedViewModel.feedActions.value is FeedActions.FetchPopularContentSuccess ||
                    feedViewModel.feedActions.value is FeedActions.FetchUpcomingContentSuccess
        )
    }

    @Test
    fun `when fetch trending content is called, get trending content`() = runTest {
        //Given
        coEvery { fetchTrendingContentUseCase("all") } returns filledList

        //When
        feedViewModel.fetchTrendingContent("all")

        //Then
        assert(feedViewModel.feedActions.value is FeedActions.FetchTrendingContentSuccess)
    }

    @Test
    fun `when call onCreate, then run Loadings`() = runTest {
        //Given
        coEvery { fetchUpcomingContentUseCase() } returns filledList

        //When
        feedViewModel.onCreate()

        //Then
        verify { observer.onChanged(FeedActions.ShowLoading) }
        verify { observer.onChanged(FeedActions.HideLoading) }
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
        ),
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
        ),
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