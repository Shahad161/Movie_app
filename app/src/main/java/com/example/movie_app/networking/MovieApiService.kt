package com.example.movie_app.networking

import com.example.movie_app.data.model.MovieResponse
import com.example.movie_app.data.model.actor.Actor
import com.example.movie_app.data.model.actor.details.ActorDetails
import com.example.movie_app.data.model.genre.Genre
import com.example.movie_app.data.movieDetails.MovieDetails
import com.example.movie_app.data.tv.Tv
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {

    @GET("movie/popular")
    suspend fun getPopularMovie(
        @Query("api_key") apiKey: String?,
        ): Response<MovieResponse>

    @GET("search/movie")
    suspend fun getMovie(
        @Query("api_key") apiKey: String?,
        @Query("query") movieName: String?,
        ): Response<MovieResponse>

    @GET("movie/{movie_id}/similar")
    suspend fun getSimilarMovie(
        @Path("movie_id") personId: Int?,
        @Query("api_key") apiKey: String?,
    ): Response<MovieResponse>


    @GET("discover/movie")
    suspend fun getGenreList(
        @Query("api_key") apiKey: String?,
        @Query("with_genres") genreId: String?,
        ): Response<MovieResponse>

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Int?,
        @Query("api_key") apiKey: String?,
    ): Response<MovieDetails>


    @GET("trending/{media_type}/{time_window}")
    suspend fun getTrendingMovie(
        @Path("media_type") movieType: String?,
        @Path("time_window") timeWindow: String?,
        @Query("api_key") apiKey: String?,
    ): Response<MovieResponse>


    @GET("genre/movie/list")
    suspend fun getGenre(
        @Query("api_key") apiKey: String?,
    ): Response<Genre>


    @GET("tv/top_rated")
    suspend fun getTopRatedTV(
        @Query("api_key") apiKey: String?,
    ): Response<Tv>


    @GET("person/popular")
    suspend fun getPopularPerson(
        @Query("api_key") apiKey: String?,
        ): Response<Actor>


    @GET("person/{person_id}")
    suspend fun getActorDetails(
        @Path("person_id") personId: Int?,
        @Query("api_key") apiKey: String?,
    ): Response<ActorDetails>

}
