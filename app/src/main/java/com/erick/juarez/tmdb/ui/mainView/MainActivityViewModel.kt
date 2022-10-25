package com.erick.juarez.tmdb.ui.mainView

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
class MainActivityViewModel @Inject constructor(
    private val fetchUpcomingContentUseCase: FetchUpcomingContentUseCase,
    private val fetchPopularContentUseCase: FetchPopularContentUseCase,
    private val fetchTrendingContentUseCase: FetchTrendingContentUseCase
) : ViewModel(){
    
    val mainActivityActions: LiveData<MainActivityActions>
        get() = _mainActivityActions

    fun onCreate() =
        viewModelScope.launch {
            _mainActivityActions.postValue(MainActivityActions.ShowLoading)

            launch {
                val upcomingContentResponse = fetchUpcomingContentUseCase(1)
                _mainActivityActions.postValue(
                    MainActivityActions.FetchUpcomingContentSuccess(upcomingContentResponse)
                )

                val popularContentResponse = fetchPopularContentUseCase(1)
                _mainActivityActions.postValue(
                    MainActivityActions.FetchPopularContentSuccess(popularContentResponse)
                )

                val fetchTrendingContentResponse = fetchTrendingContentUseCase(1, MEDIA_TYPE_ALL)
                _mainActivityActions.postValue(
                    MainActivityActions.FetchTrendingContentSuccess(fetchTrendingContentResponse)
                )
            }

            _mainActivityActions.postValue(MainActivityActions.HideLoading)

        }
    
    private val _mainActivityActions: MutableLiveData<MainActivityActions> = MutableLiveData()
    
}