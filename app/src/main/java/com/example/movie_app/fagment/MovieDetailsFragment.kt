package com.example.movie_app.fagment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.movie_app.databinding.FragmentMovieDetailsBinding
import com.example.movie_app.ui.GenreForEachMovieAdapter
import com.example.movie_app.ui.MainViewModel
import com.example.movie_app.ui.SimilarMoviesAdapter

class MovieDetailsFragment : Fragment() {

    val args: MovieDetailsFragmentArgs by navArgs()

    lateinit var binding: FragmentMovieDetailsBinding
    private val viewModel: MainViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieDetailsBinding.inflate(layoutInflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val url = args.movieDetails.posterPath
        binding.movieName.text = args.movieDetails.originalTitle
        binding.star.text = args.movieDetails.voteAverage.toString()
        val popularity = args.movieDetails.popularity.toString()
        binding.popularity.text = "$popularity K"
        val runtime = args.movieDetails.runtime
        binding.time.text = "$runtime Min"
        binding.genreDetails.text = args.movieDetails.releaseDate
        binding.synopsis.text = args.movieDetails.overview
        val URL = "https://image.tmdb.org/t/p/w500$url"
        Glide.with(view).load(URL).centerCrop().into(binding.movieImage)

        val genreForEachMovie = GenreForEachMovieAdapter(mutableListOf(), viewModel)
        binding.recyclerGenreMovie.adapter = genreForEachMovie

        val similarMovie = SimilarMoviesAdapter(mutableListOf(), viewModel)
        binding.recyclerSimilarMovie.adapter = similarMovie

        binding.back.setOnClickListener {
            Navigation.findNavController(view).popBackStack()
        }

        args.movieDetails.genres.let {
            genreForEachMovie.setItems(it)
        }

        args.similarMovie.results.let {
            similarMovie.setItems(it)
        }

    }
}