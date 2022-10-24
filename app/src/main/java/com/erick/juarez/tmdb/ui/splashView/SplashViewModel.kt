package com.erick.juarez.tmdb.ui.splashView

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.erick.juarez.tmdb.domain.FetchPopularContentUseCase
import com.erick.juarez.tmdb.domain.FetchUpcomingContentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val fetchPopularContentUseCase: FetchPopularContentUseCase,
    private val fetchUpcomingContentUseCase: FetchUpcomingContentUseCase
) : ViewModel() {

    val splashScreenActions: LiveData<SplashActivityActions?>
        get() = _splashScreenActions

    fun onCreate() =
        viewModelScope.launch {
            val upcomingContentResponse = fetchUpcomingContentUseCase(1)
            _splashScreenActions.postValue(
                SplashActivityActions.FetchUpcomingContentSuccess(upcomingContentResponse)
            )

            val popularContentResponse = fetchPopularContentUseCase(1)
            _splashScreenActions.postValue(
                SplashActivityActions.FetchPopularContentSuccess(popularContentResponse)
            )

        }


    private val _splashScreenActions: MutableLiveData<SplashActivityActions?> = MutableLiveData()

}