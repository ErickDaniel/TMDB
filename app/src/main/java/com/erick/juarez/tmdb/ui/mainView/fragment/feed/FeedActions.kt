package com.erick.juarez.tmdb.ui.mainView.fragment.feed

import com.erick.juarez.tmdb.domain.model.Movie

sealed class FeedActions {

    data class FetchUpcomingContentSuccess(val tmdbResponse: List<Movie>?) : FeedActions()
    data class FetchUpcomingContentError(val msg: String) : FeedActions()

    data class FetchPopularContentSuccess(val tmdbResponse: List<Movie>?) : FeedActions()
    data class FetchPopularContentError(val msg: String) : FeedActions()

    data class FetchTrendingContentSuccess(val tmdbResponse: List<Movie>?) : FeedActions()

    data class FetchTrendingContentError(val msg: String) : FeedActions()

    object ShowLoading : FeedActions()
    object HideLoading : FeedActions()

}