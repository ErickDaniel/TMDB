package com.erick.juarez.tmdb.ui.mainView.fragment.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.erick.juarez.tmdb.domain.FetchMovieDetailUseCase
import com.erick.juarez.tmdb.domain.FetchMovieMediaUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val fetchMovieDetailUseCase: FetchMovieDetailUseCase,
    private val fetchMovieMediaUseCase: FetchMovieMediaUseCase
): ViewModel() {

    val detailActions: LiveData<DetailActions>
        get() = _detailActions

    fun onCreate(movieId: String) =
        viewModelScope.launch {
            _detailActions.postValue(DetailActions.ShowLoading)
            withContext(Dispatchers.IO) {
                val movieDetailResponse = fetchMovieDetailUseCase(movieId)
                _detailActions.postValue(
                    DetailActions.FetchMovieDetailSuccess(movieDetailResponse)
                )
            }

            _detailActions.postValue(DetailActions.HideLoading)
        }

    fun fetchMovieMedia(movieId: String) =
        viewModelScope.launch {
            _detailActions.postValue(DetailActions.ShowLoading)
            withContext(Dispatchers.IO) {
                val movieMediaResponse = fetchMovieMediaUseCase(movieId)
                _detailActions.postValue(
                    DetailActions.FetchMovieMediaSuccess(movieMediaResponse)
                )
            }

            _detailActions.postValue(DetailActions.HideLoading)
        }

    private val _detailActions: MutableLiveData<DetailActions> = MutableLiveData()

}