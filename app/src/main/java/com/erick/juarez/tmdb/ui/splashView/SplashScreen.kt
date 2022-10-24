package com.erick.juarez.tmdb.ui.splashView

import android.animation.Animator
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.erick.juarez.tmdb.databinding.SplashScreenBinding
import com.erick.juarez.tmdb.domain.model.Movie
import com.erick.juarez.tmdb.ui.mainView.MainActivity
import com.erick.juarez.tmdb.util.printLogE
import com.erick.juarez.tmdb.util.printLogI
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
        setupAnimation()
    }

    private fun setupAnimation(){
        binding.lottieSplashAnimation.addAnimatorListener(object: Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {}

            override fun onAnimationEnd(animation: Animator) {
                if(binding.progressSplashScreen.visibility == VISIBLE){
                    binding.lottieSplashAnimation.playAnimation()
                } else {
                    launchMainView()
                    this@SplashScreen.finish()
                }
            }

            override fun onAnimationCancel(animation: Animator) {}

            override fun onAnimationRepeat(animation: Animator) {}

        })
    }

    private fun launchMainView(){
        startActivity(Intent(this, MainActivity::class.java))
    }

    private fun popularContentSaved(popularContent: List<Movie>?) =
        printLogI(popularContent.toString(), true)


    private fun upcomingContentSaved(upcomingContent: List<Movie>?) =
        printLogI(upcomingContent.toString(), true)

    private fun trendingContentSaved(popularContent: List<Movie>?) =
        printLogI(popularContent.toString(), true)

    private fun errorSavingContent() {
        printLogE("Error Saving Content", true)
    }

    private fun startLoading() {
        binding.progressSplashScreen.visibility = VISIBLE
    }

    private fun stopLoading() {
        binding.progressSplashScreen.visibility = GONE
    }

    private fun observeViewModel() =
        viewModel.splashScreenActions.observe(this) {
            when (it) {
                is SplashActivityActions.FetchPopularContentSuccess ->
                    popularContentSaved(it.tmdbResponse)
                is SplashActivityActions.FetchPopularContentError ->
                    errorSavingContent()
                is SplashActivityActions.FetchUpcomingContentSuccess ->
                    upcomingContentSaved(it.tmdbResponse)
                is SplashActivityActions.FetchUpcomingContentError ->
                    errorSavingContent()
                is SplashActivityActions.FetchTrendingContentSuccess ->
                    trendingContentSaved(it.tmdbResponse)
                is SplashActivityActions.FetchTrendingContentError ->
                    errorSavingContent()
                SplashActivityActions.ShowLoading -> startLoading()
                SplashActivityActions.HideLoading -> stopLoading()
            }
        }

}