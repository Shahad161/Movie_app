package com.example.movie_app.networking

import com.example.movie_app.data.model.MovieResponse
import com.example.movie_app.data.model.cast.Cast
import com.example.movie_app.data.model.genre.Genre
import com.example.movie_app.data.movieDetails.MovieDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {

    @GET("movie/popular")
    suspend fun getPopularMovie(
        @Query("api_key") apiKey: String?,
        ): Response<MovieResponse>

    @GET("movie/upcoming")
    suspend fun getUpcomingMovie(
        @Query("api_key") apiKey: String?,
    ): Response<MovieResponse>

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovie(
        @Query("api_key") apiKey: String?,
    ): Response<MovieResponse>

    @GET("movie/latest")
    suspend fun getLatestMovie(
        @Query("api_key") apiKey: String?,
    ): Response<MovieResponse>

    @GET("movie/now_playing")
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

    @GET("movie/{movie_id}/credits")
    suspend fun getCastMovie(
        @Path("movie_id") castId: Int?,
        @Query("api_key") apiKey: String?,
    ): Response<Cast>
}
