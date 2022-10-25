package com.erick.juarez.tmdb.ui.mainView.fragment.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(

): ViewModel() {

    val detailActions: LiveData<DetailActions>
        get() = _detailActions


    private val _detailActions: MutableLiveData<DetailActions> = MutableLiveData()

}