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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityMainBinding.inflate(layoutInflater).root)
    }

}