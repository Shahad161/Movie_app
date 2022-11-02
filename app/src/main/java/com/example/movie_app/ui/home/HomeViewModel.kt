package com.example.movie_app.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.movie_app.data.repository.MovieRepository

class HomeViewModel: ViewModel() {

    private val repository = MovieRepository()

    var trendingMovie = repository.trendingMovie().asLiveData()
    var popularMovie = repository.popularMovie().asLiveData()
    var movieGenre = repository.genre().asLiveData()

}