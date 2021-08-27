package com.example.movie_app.networking

import com.example.movie_app.data.model.MovieResponse
import com.example.movie_app.data.model.genre.Genre
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

    @GET("movie/popular")
    suspend fun getPopularMovie(
        @Query("api_key") apiKey: String?,
        ): Response<MovieResponse>


    @GET("movie/top_rated")
    suspend fun getTopRatedMovie(
        @Query("api_key") apiKey: String?,
    ): Response<MovieResponse>

    @GET("search/movie")
    suspend fun getMovie(
        @Query("api_key") apiKey: String?,
        @Query("query") movieName: String?,
        ): Response<MovieResponse>


    @GET("genre/movie/list")
    suspend fun getGenre(
        @Query("api_key") apiKey: String?,
    ): Response<Genre>

    @GET("discover/movie")
    suspend fun getGenreList(
        @Query("api_key") apiKey: String?,
        @Query("with_genres") genreId: String?,
        ): Response<MovieResponse>

}