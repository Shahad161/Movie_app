package com.example.movie_app.ui

import android.util.Log
import androidx.lifecycle.*
import com.example.movie_app.MovieRepository
import com.example.movie_app.State
import com.example.movie_app.data.domain.HomeItem
import com.example.movie_app.data.domain.HomeItemType
import com.example.movie_app.data.model.Movie
import com.example.movie_app.data.model.MovieResponse
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel: ViewModel(), MovieInteractionListener {

    private val repository = MovieRepository()
    var popularMovie = repository.popularMovie().asLiveData()
    var topRatedMovie = repository.topRatedMovie().asLiveData()
    var movieGenre = repository.genre().asLiveData()


//    var movieGenreList = repository.genreList().asLiveData()

    var searchTextMovie = MutableLiveData<String?>()
    var movieSearch = MutableLiveData<State<MovieResponse?>?>()

    fun moviesOfSearch(){
        movieSearch.value = null
        viewModelScope.launch {
            repository.movieName(searchTextMovie.value.toString())?.collect {
                movieSearch.postValue(it)
            }
        }
    }

    override fun onClickMovie(movie: Movie) {
    }

}