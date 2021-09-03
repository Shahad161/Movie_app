package com.example.movie_app.fagment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.movie_app.databinding.FragmentGenreMoviesBinding
import com.example.movie_app.ui.GenreMovieListAdapter
import com.example.movie_app.ui.MainViewModel


class GenreMoviesFragment : Fragment() {

    val args: GenreMoviesFragmentArgs by navArgs()

    lateinit var binding: FragmentGenreMoviesBinding
    private val viewModel: MainViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGenreMoviesBinding.inflate(layoutInflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val genreListMovieAdapter = GenreMovieListAdapter(mutableListOf(), viewModel)
        binding.recyclerGenreListMovies.adapter = genreListMovieAdapter

        binding.back.setOnClickListener {
            Navigation.findNavController(view).popBackStack()
        }

        args.movieList.results.let {
            genreListMovieAdapter.setItems(it)
        }

        binding.genreMovie.text = args.geneerName
        viewModel.movieDetails.observe(viewLifecycleOwner, {
            if (it?.toData() != null ) {
                val action = GenreMoviesFragmentDirections.actionGenreMoviesFragment2ToMovieDetailsFragment(it.toData()!!, viewModel.similarMovie.value?.toData()!!)
                Navigation.findNavController(view).navigate(action)
            }
        })

    }

    override fun onStop() {
        super.onStop()
        viewModel.movieDetails.value = null
    }

}