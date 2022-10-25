package com.erick.juarez.tmdb.ui.mainView.fragment.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.erick.juarez.tmdb.domain.FetchPopularContentUseCase
import com.erick.juarez.tmdb.domain.FetchTrendingContentUseCase
import com.erick.juarez.tmdb.domain.FetchUpcomingContentUseCase
import com.erick.juarez.tmdb.ui.ALL_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val fetchUpcomingContentUseCase: FetchUpcomingContentUseCase,
    private val fetchPopularContentUseCase: FetchPopularContentUseCase,
    private val fetchTrendingContentUseCase: FetchTrendingContentUseCase
): ViewModel() {

    val feedActions: LiveData<FeedActions>
        get() = _feedActions

    fun onCreate() =
        viewModelScope.launch {
            _feedActions.postValue(FeedActions.ShowLoading)

            launch {
                val upcomingContentResponse = fetchUpcomingContentUseCase()
                _feedActions.postValue(
                    FeedActions.FetchUpcomingContentSuccess(upcomingContentResponse)
                )

                val popularContentResponse = fetchPopularContentUseCase()
                _feedActions.postValue(
                    FeedActions.FetchPopularContentSuccess(popularContentResponse)
                )

                val fetchTrendingContentResponse = fetchTrendingContentUseCase(ALL_KEY)
                _feedActions.postValue(
                    FeedActions.FetchTrendingContentSuccess(fetchTrendingContentResponse)
                )
            }

            _feedActions.postValue(FeedActions.HideLoading)

        }

    fun fetchTrendingContent(mediaType: String) =
        viewModelScope.launch {
            _feedActions.postValue(FeedActions.ShowLoading)
            launch {
                val fetchTrendingContentResponse = fetchTrendingContentUseCase(mediaType)
                _feedActions.postValue(
                    FeedActions.FetchTrendingContentSuccess(fetchTrendingContentResponse)
                )
            }
            _feedActions.postValue(FeedActions.HideLoading)
        }

    private val _feedActions: MutableLiveData<FeedActions> = MutableLiveData()

}