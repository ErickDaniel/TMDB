package com.erick.juarez.tmdb.ui.splashView

import com.erick.juarez.tmdb.data.model.TMDBResponse

sealed class SplashActivityActions {

    data class FetchUpcomingContentSuccess(val tmdbResponse: TMDBResponse?) : SplashActivityActions()
    data class FetchUpcomingContentError(val msg: String) : SplashActivityActions()

    data class FetchPopularContentSuccess(val tmdbResponse: TMDBResponse?) : SplashActivityActions()
    data class FetchPopularContentError(val msg: String) : SplashActivityActions()

}