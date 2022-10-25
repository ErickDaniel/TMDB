package com.erick.juarez.tmdb.ui.youtubePlayer

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.erick.juarez.tmdb.BuildConfig.YOUTUBE_KEY
import com.erick.juarez.tmdb.R
import com.erick.juarez.tmdb.ui.TMDB_VIDEO_KEY
import com.erick.juarez.tmdb.ui.TMDB_VIDEO_SUGGESTION
import com.erick.juarez.tmdb.util.printLogE
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView

class TMDBYoutubePlayer: YouTubeBaseActivity() {

    lateinit var youtubePlayer: YouTubePlayerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.youtube_player_activity)
        val mVideoKey = intent.extras?.getString(TMDB_VIDEO_KEY)
        val mVideoName = intent.extras?.getString(TMDB_VIDEO_SUGGESTION)

        findViewById<TextView>(R.id.movie_title).text = mVideoName
        youtubePlayer = findViewById(R.id.youtubePlayer)
        youtubePlayer.initialize(YOUTUBE_KEY, object: YouTubePlayer.OnInitializedListener{
            override fun onInitializationSuccess(
                youtubePlayerProvider: YouTubePlayer.Provider?,
                youtubePlayer: YouTubePlayer?,
                wasRestored: Boolean) {
                youtubePlayer?.loadVideo(mVideoKey)
                youtubePlayer?.play()
            }

            override fun onInitializationFailure(
                youtubePlayerProvider: YouTubePlayer.Provider?,
                youtubePlayerResult: YouTubeInitializationResult?) {
                printLogE(youtubePlayerResult?.toString(), true)
            }
        })
        findViewById<ImageView>(R.id.closeButton).setOnClickListener { finish() }
    }


}