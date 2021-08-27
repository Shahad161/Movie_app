package com.example.movie_app.fagment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.movie_app.R
import com.example.movie_app.data.domain.HomeItem
import com.example.movie_app.data.domain.HomeItemType
import com.example.movie_app.databinding.FragmentHomeBinding
import com.example.movie_app.ui.GenreAdapter
import com.example.movie_app.ui.MainViewModel
import com.example.movie_app.ui.PopularMovieAdapter
import com.example.movie_app.ui.TopRatedMovieAdapter

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    private val viewModel: MainViewModel by viewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

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



//        binding.button.setOnClickListener { v ->
//            Navigation.findNavController(v).navigate(R.id.action_AFragment_to_CFragment)
//        }
    }

}