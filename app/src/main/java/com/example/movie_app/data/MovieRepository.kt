package com.example.movie_app.data

import com.example.movie_app.utils.State
import com.example.movie_app.data.model.MovieResponse
import com.example.movie_app.networking.Api
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import java.lang.Exception

class MovieRepository {

    fun popularMovie() = wrapWithFlow { Api.apiService.getPopularMovie(Constants.API_KEY) }
    fun movieName(movieName: String): Flow<State<MovieResponse?>>? {
        if (movieName == "") {
            return null
        }
        return wrapWithFlow { Api.apiService.getMovie(Constants.API_KEY, movieName) }
    }

    fun genre() = wrapWithFlow { Api.apiService.getGenre(Constants.API_KEY) }
    fun genreList(genreId: String) = wrapWithFlow { Api.apiService.getGenreList(Constants.API_KEY, genreId ) }
    fun movieDetails(movieId: Int) = wrapWithFlow { Api.apiService.getMovieDetails(movieId, Constants.API_KEY) }
    fun trendingMovie() = wrapWithFlow { Api.apiService.getTrendingMovie("movie","week", Constants.API_KEY) }
    fun similarMovie(movieId: Int) = wrapWithFlow { Api.apiService.getSimilarMovie(movieId, Constants.API_KEY) }
    fun topRatedTV() = wrapWithFlow { Api.apiService.getTopRatedTV(Constants.API_KEY) }
    fun popularPerson() = wrapWithFlow { Api.apiService.getPopularPerson(Constants.API_KEY) }
    fun actorDetailsBio(actorId: Int) = wrapWithFlow { Api.apiService.getActorDetails(actorId, Constants.API_KEY )}



    fun <T> wrapWithFlow(function: suspend () -> Response<T>): Flow<State<T?>> {
        return flow {
            emit(State.Loading)
            try {
                val result = function()
                if (result.isSuccessful) {
                    emit(State.Success(result.body()))
                } else {
                    emit(State.Error(result.message()))
                }
            } catch (e: Exception) {
                emit(State.Error(e.message.toString()))
            }
        }
    }


}