package com.example.movie_app.fagment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.movie_app.databinding.FragmentActorBinding
import com.example.movie_app.ui.MainViewModel
import com.example.movie_app.ui.PopularPersonAdapter
import kotlinx.coroutines.delay

class ActorFragment : Fragment() {

    lateinit var binding: FragmentActorBinding

    private val viewModel: MainViewModel by viewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentActorBinding.inflate(layoutInflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val popularPersonAdapter = PopularPersonAdapter(mutableListOf(), viewModel)
        binding.recyclerPopularPerson.adapter = popularPersonAdapter

        binding.back.setOnClickListener {
            Navigation.findNavController(view).popBackStack()
        }

        viewModel.actorDetails.observe(viewLifecycleOwner, {
            if (it != null ) {
                val action = ActorFragmentDirections.actionActorFragmentToActorsMoviesFragment(it, viewModel.genreOfMovie)
                Navigation.findNavController(view).navigate(action)
            }
        })

        viewModel.actorBio.observe(viewLifecycleOwner, {

            Log.i("logo", it.toString())
        })


    }


    override fun onStop() {
        super.onStop()
        viewModel.actorDetails.value = null
    }

}


