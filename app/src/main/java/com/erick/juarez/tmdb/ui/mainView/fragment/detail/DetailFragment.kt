package com.erick.juarez.tmdb.ui.mainView.fragment.detail

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.erick.juarez.tmdb.R
import com.erick.juarez.tmdb.data.model.TMDBGenere
import com.erick.juarez.tmdb.data.model.TMDBMovieMediaResult
import com.erick.juarez.tmdb.databinding.DetailFragmentBinding
import com.erick.juarez.tmdb.domain.model.MovieDetail
import com.erick.juarez.tmdb.ui.MOVIE_ID
import com.erick.juarez.tmdb.ui.TMDB_VIDEO_KEY
import com.erick.juarez.tmdb.ui.TMDB_VIDEO_SUGGESTION
import com.erick.juarez.tmdb.ui.youtubePlayer.TMDBYoutubePlayer
import com.erick.juarez.tmdb.util.moveImageWithPlaceholder
import com.erick.juarez.tmdb.util.orFalse
import com.erick.juarez.tmdb.util.orZero
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    lateinit var binding: DetailFragmentBinding
    private val viewModel: DetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DetailFragmentBinding.inflate(layoutInflater)
        observeViewModel()
        viewModel.onCreate(arguments?.getString(MOVIE_ID).orEmpty())
        return binding.root
    }

    private fun setupView(movieDetail: MovieDetail?) {
        with(binding) {
            if (movieDetail != null) {
                with(movieDetail) {
                    movieTitle.text = title
                    if (releaseDate?.isNotBlank().orFalse()) {
                        chipYear.text = releaseDate
                        chipYear.visibility = VISIBLE
                    }
                    if (originalLanguage?.isNotBlank().orFalse()) {
                        chipLang.text = originalLanguage
                        chipLang.visibility = VISIBLE
                    }
                    chipRate.text =
                        getString(R.string.vote_average, (voteAverage.orZero() * 5 / 10).toString())
                    if (chipRate.text.isNotBlank()) {
                        chipRate.visibility = VISIBLE
                    }
                    genereTextView.text = fillGenere(genres)
                    movieDescription.text = overview
                    moveImageWithPlaceholder(
                        posterPath.orEmpty(),
                        moviePoster,
                        moviePlaceHolder
                    )
                    watchTrailerButton.setOnClickListener {
                        viewModel.fetchMovieMedia(id.toString())
                    }
                }
            } else {
                requireView()
                    .findNavController()
                    .navigate(
                        DetailFragmentDirections.actionDetailFragmentToFeedFragment().actionId
                    )
                errorShowingDetail()
            }
        }
    }

    private fun showYoutubePlayer(movieMedia: TMDBMovieMediaResult?) {
        if(movieMedia?.results?.isNotEmpty().orFalse()) {
            val mTrailer = movieMedia?.results?.first()
            val mYoutubePlayerIntent = Intent(requireActivity(), TMDBYoutubePlayer::class.java)
            val mExtras = Bundle()
            mExtras.putString(TMDB_VIDEO_KEY, mTrailer?.key.orEmpty())
            mExtras.putString(TMDB_VIDEO_SUGGESTION, binding.movieTitle.text.toString())
            mYoutubePlayerIntent.putExtras(mExtras)
            startActivity(mYoutubePlayerIntent)
        } else {
            showErrorGettingYoutubeData()
        }
    }

    private fun fillGenere(genres: List<TMDBGenere>?) =
        StringBuilder().apply {
            genres?.forEach {
                append(it.name)
                if (it.id != genres.last().id) {
                    append(" ● ")
                }
            }
        }

    private fun errorShowingDetail() =
        Toast.makeText(context, R.string.error_getting_movie_detail, Toast.LENGTH_LONG).show()

    private fun showErrorGettingYoutubeData() =
        Toast.makeText(context, R.string.error_getting_youtube_media, Toast.LENGTH_LONG).show()

    private fun showLoading() {
        binding.progressDetailFragment.visibility = VISIBLE
    }

    private fun hideLoading() {
        binding.progressDetailFragment.visibility = GONE
    }

    private fun observeViewModel() {
        viewModel.detailActions.observe(viewLifecycleOwner) {
            when (it) {
                is DetailActions.FetchMovieDetailError ->
                    errorShowingDetail()
                is DetailActions.FetchMovieDetailSuccess ->
                    setupView(it.movieDetail)
                DetailActions.ShowLoading -> showLoading()
                DetailActions.HideLoading -> hideLoading()
                is DetailActions.FetchMovieMediaSuccess -> showYoutubePlayer(it.movieMedia)
                is DetailActions.FetchMovieMediaError -> showErrorGettingYoutubeData()
            }
        }
    }
}