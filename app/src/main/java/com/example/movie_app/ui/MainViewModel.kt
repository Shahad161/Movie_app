package com.example.movie_app.ui

import androidx.lifecycle.*
import com.example.movie_app.MovieRepository
import com.example.movie_app.State
import com.example.movie_app.data.model.Movie
import com.example.movie_app.data.model.MovieResponse
import com.example.movie_app.data.model.genre.GenreX
import com.example.movie_app.data.movieDetails.MovieDetails
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel: ViewModel(), MovieInteractionListener {

    private val repository = MovieRepository()

    var popularMovie = repository.popularMovie().asLiveData()
    var topRatedMovie = repository.topRatedMovie().asLiveData()
    var latestMovie = repository.latestMovie().asLiveData()
    var upcomingMovie = repository.upcomingMovie().asLiveData()
    var nowPlayingMovie = repository.nowPlayingMovie().asLiveData()


    var movieGenre = repository.genre().asLiveData()
    var searchTextMovie = MutableLiveData<String?>()
    var movieSearch = MutableLiveData<State<MovieResponse?>?>()
    var trendingMovie = repository.trendingMovie().asLiveData()

    fun moviesOfSearch(){
        movieSearch.value = null
        viewModelScope.launch {
            repository.movieName(searchTextMovie.value.toString())?.collect {
                movieSearch.postValue(it)
            }
        }
    }


    var movieGenreList = MutableLiveData<State<MovieResponse?>?>()
    private fun getGenre(genre: GenreX){
        viewModelScope.launch {
            repository.genreList(genre.id.toString()).collect {
                movieGenreList.postValue(it)
            }
        }
    }

    var movieDetails = MutableLiveData<State<MovieDetails?>?>()
    private fun getMovieDetails(movie: Movie){
        viewModelScope.launch {
            repository.movieDetails(movie.id!!).collect {
                movieDetails.postValue(it)

            }
        }
    }


    override fun onClickMovie(movie: Movie) {
        getMovieDetails(movie)
    }


    override fun onClickGenre(genre: GenreX) {
        getGenre(genre)
    }

}