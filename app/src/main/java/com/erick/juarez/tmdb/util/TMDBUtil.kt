package com.erick.juarez.tmdb.util

import android.view.View.GONE
import android.widget.ImageView
import com.airbnb.lottie.LottieAnimationView
import com.erick.juarez.tmdb.BuildConfig
import com.erick.juarez.tmdb.data.PATH_IMAGES
import com.squareup.picasso.Callback
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso

fun moveImageWithPlaceholder(posterPath: String, movieImage: ImageView, moviePlaceHolder: LottieAnimationView) =
    Picasso.get()
        .load(BuildConfig.BASE_URL_IMAGES.plus(PATH_IMAGES).plus(posterPath))
        .networkPolicy(NetworkPolicy.OFFLINE)
        .into(movieImage, object : Callback {
            override fun onSuccess() {
                moviePlaceHolder.visibility = GONE
            }

            override fun onError(e: Exception?) {
                Picasso.get()
                    .load(BuildConfig.BASE_URL_IMAGES.plus(PATH_IMAGES).plus(posterPath))
                    .into(movieImage, object: Callback {
                        override fun onSuccess() {
                            moviePlaceHolder.visibility = GONE
                        }

                        override fun onError(e: Exception?) {
                            moviePlaceHolder.visibility = GONE
                        }
                    })
            }
        })

