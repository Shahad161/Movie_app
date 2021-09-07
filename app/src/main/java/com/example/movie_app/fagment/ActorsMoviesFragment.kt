package com.example.movie_app.fagment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.movie_app.databinding.FragmentActorsMoviesBinding
import com.example.movie_app.ui.*

class ActorsMoviesFragment : Fragment() {

    val args: ActorsMoviesFragmentArgs by navArgs()
    lateinit var binding: FragmentActorsMoviesBinding

    private val viewModel: MainViewModel by viewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentActorsMoviesBinding.inflate(layoutInflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.back.setOnClickListener {
            Navigation.findNavController(view).popBackStack()
        }

        binding.actorName.text = args.famous.name

        val url = args.famous.profilePath
        val URL = "https://image.tmdb.org/t/p/w500$url"
        Glide.with(view).load(URL).centerCrop().into(binding.Photo)

        val actorsMoviesAdapter = ActorsMoviesAdapter(mutableListOf(), viewModel)
        binding.recyclerActorsMovies.adapter = actorsMoviesAdapter

        args.famous.knownFor.let {
            actorsMoviesAdapter.setItems(it)
        }

    }

}