package com.example.movie_app.ui.fagment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.movie_app.R
import com.example.movie_app.databinding.FragmentSearchBinding
import com.example.movie_app.ui.activity.MainViewModel
import com.example.movie_app.ui.SearchMovieAdapter
import com.example.movie_app.ui.base.BaseFragment
import com.example.movie_app.ui.home.HomeViewModel

class SearchFragment : BaseFragment<FragmentSearchBinding>() {

    override val layoutIdFragment: Int = R.layout.fragment_search

    override val viewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val searchAdapter = SearchMovieAdapter(mutableListOf(), viewModel)
        binding.recyclerSearchMovie.adapter = searchAdapter


        binding.back.setOnClickListener {
            Navigation.findNavController(view).popBackStack()
        }

        viewModel.movieDetails.observe(viewLifecycleOwner) {
            if (it?.toData() != null) {
                val action =
                    SearchFragmentDirections.actionSearchFragmentToMovieDetailsFragment(it.toData()!!,
                        viewModel.similarMovie.value?.toData()!!)
                Navigation.findNavController(view).navigate(action)
            }
        }


    }

    override fun onStop() {
        super.onStop()
        viewModel.movieDetails.value = null
        viewModel.similarMovie.value = null

    }

}