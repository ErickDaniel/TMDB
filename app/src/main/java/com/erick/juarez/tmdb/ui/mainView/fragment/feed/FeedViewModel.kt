package com.erick.juarez.tmdb.ui.mainView.fragment.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.erick.juarez.tmdb.data.MEDIA_TYPE_ALL
import com.erick.juarez.tmdb.domain.FetchPopularContentUseCase
import com.erick.juarez.tmdb.domain.FetchTrendingContentUseCase
import com.erick.juarez.tmdb.domain.FetchUpcomingContentUseCase
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
                val upcomingContentResponse = fetchUpcomingContentUseCase(1)
                _feedActions.postValue(
                    FeedActions.FetchUpcomingContentSuccess(upcomingContentResponse)
                )

                val popularContentResponse = fetchPopularContentUseCase(1)
                _feedActions.postValue(
                    FeedActions.FetchPopularContentSuccess(popularContentResponse)
                )

                val fetchTrendingContentResponse = fetchTrendingContentUseCase(1, MEDIA_TYPE_ALL)
                _feedActions.postValue(
                    FeedActions.FetchTrendingContentSuccess(fetchTrendingContentResponse)
                )
            }

            _feedActions.postValue(FeedActions.HideLoading)

        }

    private val _feedActions: MutableLiveData<FeedActions> = MutableLiveData()

}