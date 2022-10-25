package com.erick.juarez.tmdb.ui.mainView

import com.erick.juarez.tmdb.domain.model.Movie

sealed class MainActivityActions {

    data class FetchUpcomingContentSuccess(val tmdbResponse: List<Movie>?) : MainActivityActions()
    data class FetchUpcomingContentError(val msg: String) : MainActivityActions()

    data class FetchPopularContentSuccess(val tmdbResponse: List<Movie>?) : MainActivityActions()
    data class FetchPopularContentError(val msg: String) : MainActivityActions()

    data class FetchTrendingContentSuccess(val tmdbResponse: List<Movie>?) : MainActivityActions()
    data class FetchTrendingContentError(val msg: String) : MainActivityActions()

    object ShowLoading: MainActivityActions()
    object HideLoading: MainActivityActions()

}