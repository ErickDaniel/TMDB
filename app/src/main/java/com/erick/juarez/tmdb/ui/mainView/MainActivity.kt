package com.erick.juarez.tmdb.ui.mainView

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.erick.juarez.tmdb.databinding.ActivityMainBinding
import com.erick.juarez.tmdb.domain.model.Movie
import com.erick.juarez.tmdb.ui.mainView.adapter.PopularContentAdapter
import com.erick.juarez.tmdb.util.CustomLinearLayoutManager
import com.erick.juarez.tmdb.util.printLogE
import com.erick.juarez.tmdb.util.printLogI
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModels()

    //Upcoming Movies
    private var upcomingMovieList = mutableListOf<Movie>()
    private var upcomingMovieAdapter = PopularContentAdapter(upcomingMovieList)

    //Popular Movies
    private var popularMovieList = mutableListOf<Movie>()
    private var popularMovieAdapter = PopularContentAdapter(popularMovieList)

    //Trending Movies
    private var trendingMovieList = mutableListOf<Movie>()
    private var trendingMovieAdapter = PopularContentAdapter(trendingMovieList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observeViewModel()
        viewModel.onCreate()
        setupAdapters()
    }

    private fun setupAdapters(){
        with(binding){
            recyclerPopularContent.adapter = popularMovieAdapter
            recyclerPopularContent.layoutManager = CustomLinearLayoutManager(applicationContext)

            recyclerUpcomingContent.adapter = upcomingMovieAdapter
            recyclerUpcomingContent.layoutManager = CustomLinearLayoutManager(applicationContext)

            recyclerTrendingContent.adapter = trendingMovieAdapter
            recyclerTrendingContent.isNestedScrollingEnabled = false
            recyclerTrendingContent.layoutManager = GridLayoutManager(applicationContext, 2)
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

    private fun observeViewModel() =
        viewModel.mainActivityActions.observe(this) {
            when (it) {
                is MainActivityActions.FetchPopularContentSuccess ->
                    onPopularContentFetched(it.tmdbResponse)
                is MainActivityActions.FetchPopularContentError ->
                    errorSavingContent()
                is MainActivityActions.FetchUpcomingContentSuccess ->
                    onUpcomingContentFetched(it.tmdbResponse)
                is MainActivityActions.FetchUpcomingContentError ->
                    errorSavingContent()
                is MainActivityActions.FetchTrendingContentSuccess ->
                    onTrendingContentFetched(it.tmdbResponse)
                is MainActivityActions.FetchTrendingContentError ->
                    errorSavingContent()
                MainActivityActions.ShowLoading -> startLoading()
                MainActivityActions.HideLoading -> stopLoading()
            }
        }

}