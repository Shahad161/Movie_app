package com.example.movie_app.fagment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.movie_app.R
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


        binding.back.setOnClickListener {
            Navigation.findNavController(view).popBackStack()
        }

        viewModel.movieDetails.observe(viewLifecycleOwner, {
            if (it?.toData() != null ) {
                val action = SearchFragmentDirections.actionSearchFragmentToMovieDetailsFragment(it.toData()!!, viewModel.similarMovie.value?.toData()!!)
                Navigation.findNavController(view).navigate(action)
            }
        })



    }

    override fun onStop() {
        super.onStop()
        viewModel.movieDetails.value = null
        viewModel.similarMovie.value = null

    }

}