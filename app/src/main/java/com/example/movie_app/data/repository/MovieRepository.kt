package com.example.movie_app.data.repository

import com.example.movie_app.data.remote.Constants
import com.example.movie_app.utils.State
import com.example.movie_app.data.remote.response.MovieResponse
import com.example.movie_app.data.remote.service.AuthInterceptor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import java.lang.Exception

class MovieRepository {

    fun popularMovie() = wrapWithFlow { AuthInterceptor.apiService.getPopularMovie(Constants.API_KEY) }
    fun movieName(movieName: String): Flow<State<MovieResponse?>>? {
        if (movieName == "") {
            return null
        }
        return wrapWithFlow { AuthInterceptor.apiService.getMovie(Constants.API_KEY, movieName) }
    }

    fun genre() = wrapWithFlow { AuthInterceptor.apiService.getGenre(Constants.API_KEY) }
    fun genreList(genreId: String) = wrapWithFlow { AuthInterceptor.apiService.getGenreList(
        Constants.API_KEY, genreId ) }
    fun movieDetails(movieId: Int) = wrapWithFlow { AuthInterceptor.apiService.getMovieDetails(movieId,
        Constants.API_KEY) }
    fun trendingMovie() = wrapWithFlow { AuthInterceptor.apiService.getTrendingMovie("movie","week",
        Constants.API_KEY) }
    fun similarMovie(movieId: Int) = wrapWithFlow { AuthInterceptor.apiService.getSimilarMovie(movieId,
        Constants.API_KEY) }
    fun topRatedTV() = wrapWithFlow { AuthInterceptor.apiService.getTopRatedTV(Constants.API_KEY) }
    fun popularPerson() = wrapWithFlow { AuthInterceptor.apiService.getPopularPerson(Constants.API_KEY) }
    fun actorDetailsBio(actorId: Int) = wrapWithFlow { AuthInterceptor.apiService.getActorDetails(actorId,
        Constants.API_KEY)}



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