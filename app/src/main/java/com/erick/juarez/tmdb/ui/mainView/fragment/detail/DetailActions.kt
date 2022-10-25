package com.erick.juarez.tmdb.ui.mainView.fragment.detail

import com.erick.juarez.tmdb.data.model.TMDBMovieMediaResult
import com.erick.juarez.tmdb.domain.model.MovieDetail


sealed class DetailActions {

    data class FetchMovieDetailSuccess(val movieDetail: MovieDetail?) : DetailActions()
    data class FetchMovieDetailError(val msg: String) : DetailActions()

    data class FetchMovieMediaSuccess(val movieMedia: TMDBMovieMediaResult?) : DetailActions()
    data class FetchMovieMediaError(val msg: String) : DetailActions()

    object ShowLoading: DetailActions()
    object HideLoading: DetailActions()
}