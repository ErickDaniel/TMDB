package com.erick.juarez.tmdb.ui.splashView

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.erick.juarez.tmdb.data.model.TMDBResponse
import com.erick.juarez.tmdb.databinding.SplashScreenBinding
import dagger.hilt.android.AndroidEntryPoint

@SuppressLint("CustomSplashScreen") //Suppressing the new SplashScreen api warning (Android 12 - SplashScreen)
@AndroidEntryPoint
class SplashScreen : AppCompatActivity() {

    private lateinit var binding: SplashScreenBinding
    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observeViewModel()
        viewModel.onCreate()
    }

    private fun savePopularContentOnDb(tmdbResponse: TMDBResponse?) {
        print(tmdbResponse)
    }

    private fun saveUpcomingContentOnDb(tmdbResponse: TMDBResponse?) {
        print(tmdbResponse)
    }

    private fun observeViewModel() = viewModel.splashScreenActions.observe(this) {
        when (it) {
            is SplashActivityActions.FetchPopularContentSuccess ->
                savePopularContentOnDb(it.tmdbResponse)
            is SplashActivityActions.FetchPopularContentError -> TODO()
            is SplashActivityActions.FetchUpcomingContentSuccess ->
                saveUpcomingContentOnDb(it.tmdbResponse)
            is SplashActivityActions.FetchUpcomingContentError -> TODO()
            null -> TODO()
        }
    }

}