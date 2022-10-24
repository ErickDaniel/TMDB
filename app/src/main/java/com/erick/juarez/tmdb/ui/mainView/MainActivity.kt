package com.erick.juarez.tmdb.ui.mainView

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.erick.juarez.tmdb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

}