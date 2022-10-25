package com.erick.juarez.tmdb.ui.splashView

import android.animation.Animator
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.erick.juarez.tmdb.databinding.SplashScreenBinding
import com.erick.juarez.tmdb.ui.mainView.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@SuppressLint("CustomSplashScreen") //Suppressing the new SplashScreen api warning (Android 12 - SplashScreen)
@AndroidEntryPoint
class SplashScreen : AppCompatActivity() {

    private lateinit var binding: SplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupAnimation()
    }

    private fun setupAnimation(){
        binding.lottieSplashAnimation.addAnimatorListener(object: Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {}

            override fun onAnimationEnd(animation: Animator) {
                launchMainView()
                this@SplashScreen.finish()
            }

            override fun onAnimationCancel(animation: Animator) {}

            override fun onAnimationRepeat(animation: Animator) {}

        })
    }

    private fun launchMainView(){
        startActivity(Intent(this, MainActivity::class.java))
    }

}