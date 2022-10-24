package com.erick.juarez.tmdb.ui.splashView

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
class SplashViewModel @Inject constructor(
    private val fetchPopularContentUseCase: FetchPopularContentUseCase,
    private val fetchUpcomingContentUseCase: FetchUpcomingContentUseCase,
    private val fetchTrendingContentUseCase: FetchTrendingContentUseCase
) : ViewModel() {

    val splashScreenActions: LiveData<SplashActivityActions>
        get() = _splashScreenActions

    fun onCreate() =
        viewModelScope.launch {
            _splashScreenActions.postValue(SplashActivityActions.ShowLoading)
            val upcomingContentResponse = fetchUpcomingContentUseCase(1)
            _splashScreenActions.postValue(
                SplashActivityActions.FetchUpcomingContentSuccess(upcomingContentResponse)
            )

            val popularContentResponse = fetchPopularContentUseCase(1)
            _splashScreenActions.postValue(
                SplashActivityActions.FetchPopularContentSuccess(popularContentResponse)
            )

            val fetchTrendingContentResponse = fetchTrendingContentUseCase(1, MEDIA_TYPE_ALL)
            _splashScreenActions.postValue(
                SplashActivityActions.FetchTrendingContentSuccess(fetchTrendingContentResponse)
            )

            _splashScreenActions.postValue(SplashActivityActions.HideLoading)

        }


    private val _splashScreenActions: MutableLiveData<SplashActivityActions> = MutableLiveData()

}