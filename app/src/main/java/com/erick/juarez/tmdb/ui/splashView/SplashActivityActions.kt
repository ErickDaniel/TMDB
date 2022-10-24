package com.erick.juarez.tmdb.ui.splashView

import com.erick.juarez.tmdb.domain.model.Movie

sealed class SplashActivityActions {

    data class FetchUpcomingContentSuccess(val tmdbResponse: List<Movie>?) : SplashActivityActions()
    data class FetchUpcomingContentError(val msg: String) : SplashActivityActions()

    data class FetchPopularContentSuccess(val tmdbResponse: List<Movie>?) : SplashActivityActions()
    data class FetchPopularContentError(val msg: String) : SplashActivityActions()

    data class FetchTrendingContentSuccess(val tmdbResponse: List<Movie>?) : SplashActivityActions()
    data class FetchTrendingContentError(val msg: String) : SplashActivityActions()

    object ShowLoading: SplashActivityActions()
    object HideLoading: SplashActivityActions()

}