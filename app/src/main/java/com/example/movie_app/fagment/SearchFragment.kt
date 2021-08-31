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
import com.example.movie_app.data.model.cast.Cast
import com.example.movie_app.data.movieDetails.MovieDetails
import com.example.movie_app.databinding.FragmentSearchBinding
import com.example.movie_app.ui.MainViewModel
import com.example.movie_app.ui.SearchMovieAdapter

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


        viewModel.movieDetails.observe(viewLifecycleOwner, {
            if (it?.toData() != null ) {
                val action = SearchFragmentDirections.actionSearchFragmentToMovieDetailsFragment(it.toData()!!)
                Navigation.findNavController(view).navigate(action)
            }
        })

//        viewModel.movieCast.observe(viewLifecycleOwner, {
//            if (it?.toData() != null ) {
//                cast.add(it.toData()!!)
//            }

    }

    override fun onStop() {
        super.onStop()
        viewModel.movieDetails.value = null

    }

}