package com.example.movie_app.fagment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.example.movie_app.R
import com.example.movie_app.State
import com.example.movie_app.data.model.MovieResponse
import com.example.movie_app.databinding.FragmentHomeBinding
import com.example.movie_app.ui.GenreAdapter
import com.example.movie_app.ui.MainViewModel
import com.example.movie_app.ui.PopularMovieAdapter
import com.example.movie_app.ui.TopRatedMovieAdapter
import com.example.movie_app.utils.notifyObserver
import okhttp3.internal.notify
import okhttp3.internal.notifyAll

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    private val viewModel: MainViewModel by viewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val popularAdapter = PopularMovieAdapter(mutableListOf(), viewModel)
        binding.recyclerPopularMovie.adapter = popularAdapter

        val topRatedAdapter = TopRatedMovieAdapter(mutableListOf(), viewModel)
        binding.recyclerTopRateMovie.adapter = topRatedAdapter

        val genreAdapter = GenreAdapter(mutableListOf(), viewModel)
        binding.recyclerGenreMovie.adapter = genreAdapter


        binding.searchIcon.setOnClickListener { v ->
            Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_searchFragment)
        }

        viewModel.movieGenreList.observe(viewLifecycleOwner, {
            if (it?.toData() != null ) {
                val action =
                    HomeFragmentDirections.actionHomeFragmentToGenreMoviesFragment2(it.toData()!!)
                Navigation.findNavController(view).navigate(action)
            }
        })
    }

    override fun onStop() {
        super.onStop()
        viewModel.movieGenreList.value = null
    }

}
