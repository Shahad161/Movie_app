package com.example.movie_app.ui.fagment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.movie_app.databinding.FragmentTVBinding
import com.example.movie_app.ui.AllTVAdapter
import com.example.movie_app.ui.activity.MainViewModel

class TVFragment : Fragment() {

    lateinit var binding: FragmentTVBinding

    private val viewModel: MainViewModel by viewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentTVBinding.inflate(layoutInflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val topRateTVAdapter = AllTVAdapter(mutableListOf(), viewModel)
        binding.recyclerTopRateTv.adapter = topRateTVAdapter

        binding.back.setOnClickListener {
            Navigation.findNavController(view).popBackStack()
        }


    }

}