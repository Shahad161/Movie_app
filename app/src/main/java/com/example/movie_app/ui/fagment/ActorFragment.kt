package com.example.movie_app.ui.fagment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.*
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.movie_app.databinding.FragmentActorBinding
import com.example.movie_app.ui.activity.MainViewModel
import com.example.movie_app.ui.PopularPersonAdapter


class ActorFragment : Fragment() {

    lateinit var binding: FragmentActorBinding

    private val viewModel: MainViewModel by activityViewModels()
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

        viewModel.actorDetails.observe(viewLifecycleOwner) {
            if (it != null) {
                val action = ActorFragmentDirections.actionActorFragmentToActorsMoviesFragment(it)
                Navigation.findNavController(view).navigate(action)
            }
        }

    }


    override fun onStop() {
        super.onStop()
        viewModel.actorDetails.value = null
    }

}


