package com.example.movie_app.ui.fagment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.movie_app.databinding.FragmentGenreListBinding
import com.example.movie_app.ui.GenreListAdapter
import com.example.movie_app.ui.viewModel.MainViewModel



class GenreListFragment : Fragment() {

    lateinit var binding: FragmentGenreListBinding
    private val viewModel: MainViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGenreListBinding.inflate(layoutInflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.back.setOnClickListener {
            Navigation.findNavController(view).popBackStack()
        }

        val genreAdapter = GenreListAdapter(mutableListOf(), viewModel)
        binding.recyclerGenreList.adapter = genreAdapter

        viewModel.movieGenreList.observe(viewLifecycleOwner) {
            if (it?.toData() != null) {
                val action =
                    GenreListFragmentDirections.actionGenreListFragmentToGenreMoviesFragment2(it.toData()!!,
                        viewModel.genreOfMovie)
                Navigation.findNavController(view).navigate(action)
            }
        }
    }
    override fun onStop() {
        super.onStop()
        viewModel.movieGenreList.value = null
    }
}