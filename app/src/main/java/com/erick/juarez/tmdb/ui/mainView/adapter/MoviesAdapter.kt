package com.erick.juarez.tmdb.ui.mainView.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.erick.juarez.tmdb.R
import com.erick.juarez.tmdb.databinding.RowMovieBinding
import com.erick.juarez.tmdb.domain.model.Movie
import com.erick.juarez.tmdb.ui.mainView.viewHolder.MovieViewHolder

class MoviesAdapter(
    private var movieList: List<Movie>,
    private val onItemClick: (movieId: String) -> Unit
) : RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MovieViewHolder(
            RowMovieBinding.bind(
                LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.row_movie, parent, false)
            ).root
        )

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) =
        holder.render(movieList[position], onItemClick)


    override fun getItemCount() = movieList.size

    fun submitList(movieList: List<Movie>) {
        this.movieList = movieList
        notifyItemRangeChanged(0, movieList.size)
    }

}