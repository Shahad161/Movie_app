package com.example.movie_app.ui.viewModel

import androidx.lifecycle.*
import com.example.movie_app.data.repository.MovieRepository
import com.example.movie_app.utils.State
import com.example.movie_app.data.remote.response.Movie
import com.example.movie_app.data.remote.response.MovieResponse
import com.example.movie_app.data.remote.response.actor.Famous
import com.example.movie_app.data.remote.response.genre.GenreX
import com.example.movie_app.data.remote.response.movieDetails.MovieDetails
import com.example.movie_app.ui.MovieInteractionListener
import kotlinx.coroutines.launch

class MainViewModel: ViewModel(), MovieInteractionListener {

    private val repository = MovieRepository()
    var popularMovie = repository.popularMovie().asLiveData()
    var movieGenre = repository.genre().asLiveData()
    var searchTextMovie = MutableLiveData<String?>()
    var movieSearch = MutableLiveData<State<MovieResponse?>?>()
    var trendingMovie = repository.trendingMovie().asLiveData()
    var topRatedTV = repository.topRatedTV().asLiveData()
    var popularPerson = repository.popularPerson().asLiveData()
    var actorDetails = MutableLiveData<Famous?>()

    fun moviesOfSearch(){
        movieSearch.value = null
        viewModelScope.launch {
            repository.movieName(searchTextMovie.value.toString())?.collect {
                movieSearch.postValue(it)
            }
        }
    }

    var movieGenreList = MutableLiveData<State<MovieResponse?>?>()
    var genreOfMovie = ""
    private fun getGenre(genre: GenreX){
        viewModelScope.launch {
            genreOfMovie = genre.name.toString()
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

    var similarMovie = MutableLiveData<State<MovieResponse?>?>()
    private fun getSimilarMovie(movie: Movie){
        similarMovie.value = null
        viewModelScope.launch {
            repository.similarMovie(movie.id!!).collect {
                similarMovie.postValue(it)
            }
        }
    }

    var actorBio = MutableLiveData<String>()
    private fun getActorDetails(famous: Famous){
        actorDetails.postValue(famous)
        viewModelScope.launch {
            repository.actorDetailsBio(famous.id!!).collect {
                actorBio.postValue(it.toData()?.biography.toString())
            }
        }
    }


    override fun onClickFamous(famous: Famous) {
        getActorDetails(famous)
    }

    override fun onClickMovie(movie: Movie) {
         getSimilarMovie(movie)
         getMovieDetails(movie)
    }

    override fun onClickGenre(genre: GenreX) {
        getGenre(genre)
    }

}