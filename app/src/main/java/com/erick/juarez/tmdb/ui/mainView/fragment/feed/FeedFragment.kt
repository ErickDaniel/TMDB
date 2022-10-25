package com.erick.juarez.tmdb.ui.mainView.fragment.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.erick.juarez.tmdb.databinding.FeedFragmentBinding
import com.erick.juarez.tmdb.domain.model.Movie
import com.erick.juarez.tmdb.ui.MOVIE_ID
import com.erick.juarez.tmdb.ui.mainView.adapter.MoviesAdapter
import com.erick.juarez.tmdb.util.CustomLinearLayoutManager
import com.erick.juarez.tmdb.util.printLogE
import com.erick.juarez.tmdb.util.printLogI
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeedFragment : Fragment() {

    lateinit var binding: FeedFragmentBinding
    private val viewModel: FeedViewModel by viewModels()

    //Upcoming Movies
    private var upcomingMovieList = mutableListOf<Movie>()
    private var upcomingMovieAdapter = MoviesAdapter(upcomingMovieList, ::onMovieClick)

    //Popular Movies
    private var popularMovieList = mutableListOf<Movie>()
    private var popularMovieAdapter = MoviesAdapter(popularMovieList, ::onMovieClick)

    //Trending Movies
    private var trendingMovieList = mutableListOf<Movie>()
    private var trendingMovieAdapter = MoviesAdapter(trendingMovieList, ::onMovieClick)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FeedFragmentBinding.inflate(inflater)
        observeViewModel()
        viewModel.onCreate()
        setupAdapters()
        return binding.root
    }

    private fun setupAdapters(){
        with(binding){
            recyclerPopularContent.adapter = popularMovieAdapter
            recyclerPopularContent.layoutManager = CustomLinearLayoutManager(context)

            recyclerUpcomingContent.adapter = upcomingMovieAdapter
            recyclerUpcomingContent.layoutManager = CustomLinearLayoutManager(context)

            recyclerTrendingContent.adapter = trendingMovieAdapter
            recyclerTrendingContent.isNestedScrollingEnabled = false
            recyclerTrendingContent.layoutManager = GridLayoutManager(context, 2)
        }
    }

    private fun onUpcomingContentFetched(upcomingContent: List<Movie>?) {
        printLogI(upcomingContent.toString(), true)
        upcomingMovieAdapter.submitList(upcomingContent.orEmpty())
    }

    private fun onPopularContentFetched(popularContent: List<Movie>?) {
        printLogI(popularContent.toString(), true)
        popularMovieAdapter.submitList(popularContent.orEmpty())
    }

    private fun onTrendingContentFetched(trendingContent: List<Movie>?){
        printLogI(trendingContent.toString(), true)
        trendingMovieAdapter.submitList(trendingContent.orEmpty())
    }

    private fun errorSavingContent() {
        printLogE("Error Saving Content", true)
    }

    private fun startLoading() {
        binding.progressMainActivity.visibility = View.VISIBLE
    }

    private fun stopLoading() {
        binding.progressMainActivity.visibility = View.GONE
    }

    private fun onMovieClick(movieId: String) {
        requireView()
            .findNavController()
            .navigate(
                FeedFragmentDirections.actionFeedFragmentToDetailFragment().actionId,
                Bundle().apply {
                    putString(MOVIE_ID, movieId)
                }
            )
    }

    private fun observeViewModel() =
        viewModel.feedActions.observe(viewLifecycleOwner) {
            when (it) {
                is FeedActions.FetchPopularContentSuccess ->
                    onPopularContentFetched(it.tmdbResponse)
                is FeedActions.FetchPopularContentError ->
                    errorSavingContent()
                is FeedActions.FetchUpcomingContentSuccess ->
                    onUpcomingContentFetched(it.tmdbResponse)
                is FeedActions.FetchUpcomingContentError ->
                    errorSavingContent()
                is FeedActions.FetchTrendingContentSuccess ->
                    onTrendingContentFetched(it.tmdbResponse)
                is FeedActions.FetchTrendingContentError ->
                    errorSavingContent()
                FeedActions.ShowLoading -> startLoading()
                FeedActions.HideLoading -> stopLoading()
            }
        }

}