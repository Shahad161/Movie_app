package com.example.movie_app.ui

import android.util.Log
import android.view.View
import androidx.lifecycle.*
import androidx.navigation.Navigation
import com.example.movie_app.MovieRepository
import com.example.movie_app.R
import com.example.movie_app.State
import com.example.movie_app.data.model.Movie
import com.example.movie_app.data.model.MovieResponse
import com.example.movie_app.data.model.genre.GenreX
import com.example.movie_app.utils.notifyObserver
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import okhttp3.internal.notifyAll

class MainViewModel: ViewModel(), MovieInteractionListener {

    private val repository = MovieRepository()

    var popularMovie = repository.popularMovie().asLiveData()
    var topRatedMovie = repository.topRatedMovie().asLiveData()
    var movieGenre = repository.genre().asLiveData()
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
    override fun onClickGenre(genre: GenreX) {
        getGenre(genre)
    }

    var movieGenreList = MutableLiveData<State<MovieResponse?>?>()

    private fun getGenre(genre: GenreX){
        viewModelScope.launch {
            repository.genreList(genre.id.toString()).collect {
                movieGenreList.postValue(it)
            }
        }
    }

}