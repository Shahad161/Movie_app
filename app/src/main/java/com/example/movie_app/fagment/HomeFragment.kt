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
import com.example.movie_app.R
import com.example.movie_app.databinding.FragmentHomeBinding
import com.example.movie_app.ui.*
import kotlinx.android.synthetic.main.activity_main.view.*

class HomeFragment : Fragment(), Runnable {


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

        val genreAdapter = GenreAdapter(mutableListOf(), viewModel)
        binding.recyclerGenreMovie.adapter = genreAdapter

        val trendingAdapter = TrendingAdapter(mutableListOf(), viewModel)
        binding.recyclerTrendingMovie.adapter = trendingAdapter

        binding.searchButton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_searchFragment)
        }


        viewModel.movieGenreList.observe(viewLifecycleOwner, {
            if (it?.toData() != null ) {
                val action = HomeFragmentDirections.actionHomeFragmentToGenreMoviesFragment2(it.toData()!!,viewModel.genreOfMovie)
                Navigation.findNavController(view).navigate(action)
            }
        })

        viewModel.movieDetails.observe(viewLifecycleOwner, {
            if (it?.toData() != null ) {
                val action = HomeFragmentDirections.actionHomeFragmentToMovieDetailsFragment(it.toData()!!, viewModel.similarMovie.value?.toData()!!)
                Navigation.findNavController(view).navigate(action)
            }
        })

    }

    override fun onStop() {
        super.onStop()
        viewModel.movieDetails.value = null
        viewModel.movieGenreList.value = null
        viewModel.similarMovie.value = null
    }

    override fun run() {
        TODO("Not yet implemented")
    }

}
