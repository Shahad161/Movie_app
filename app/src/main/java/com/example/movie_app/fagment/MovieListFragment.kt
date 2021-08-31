package com.example.movie_app.fagment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.movie_app.R
import com.example.movie_app.databinding.FragmentMovieListBinding
import com.example.movie_app.databinding.FragmentSearchBinding
import com.example.movie_app.ui.AllMovieAdapter
import com.example.movie_app.ui.MainViewModel
import com.example.movie_app.ui.SearchMovieAdapter

class MovieListFragment : Fragment() {

    lateinit var binding: FragmentMovieListBinding

    private val viewModel: MainViewModel by viewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMovieListBinding.inflate(layoutInflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val movieListAdapter = AllMovieAdapter(mutableListOf(), viewModel)
        binding.recyclerTopRateMovie.adapter = movieListAdapter

    }


}