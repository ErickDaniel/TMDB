package com.erick.juarez.tmdb.ui.splashView

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.erick.juarez.tmdb.databinding.SplashScreenBinding

@SuppressLint("CustomSplashScreen") //Suppressing the new SplashScreen api warning (Android 12 - SplashScreen)
class SplashScreen : AppCompatActivity() {

    private lateinit var binding: SplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}