package com.erick.juarez.tmdb.ui.mainView.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.erick.juarez.tmdb.databinding.RowMovieBinding
import com.erick.juarez.tmdb.domain.model.Movie
import com.erick.juarez.tmdb.util.moveImageWithPlaceholder

class MovieViewHolder constructor(
    view: View
) : RecyclerView.ViewHolder(view) {

    private val binding = RowMovieBinding.bind(view)

    fun render(movie: Movie) =
        with(movie) {
            with(binding) {
                moveImageWithPlaceholder(
                    posterPath.orEmpty(),
                    moviePoster,
                    moviePlaceHolder
                )
            }
        }

}