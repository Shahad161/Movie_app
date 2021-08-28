package com.example.movie_app.fagment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.movie_app.databinding.FragmentSearchBinding
import com.example.movie_app.ui.MainViewModel
import com.example.movie_app.ui.SearchMovieAdapter
import com.example.movie_app.ui.TopRatedMovieAdapter

class SearchFragment : Fragment() {

    lateinit var binding: FragmentSearchBinding

    private val viewModel: MainViewModel by viewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSearchBinding.inflate(layoutInflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val searchAdapter = SearchMovieAdapter(mutableListOf(), viewModel)
        binding.recyclerSearchMovie.adapter = searchAdapter

    }

}