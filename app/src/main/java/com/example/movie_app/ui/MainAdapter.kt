package com.example.movie_app.ui

import com.example.movie_app.R
import com.example.movie_app.data.model.Movie
import com.example.movie_app.data.model.genre.GenreX

class PopularMovieAdapter(items: List<Movie>, listener:MovieInteractionListener): BaseAdapter<Movie>(items, listener) {
    override val layoutId: Int = R.layout.item_movie
}

class TopRatedMovieAdapter(items: List<Movie>, listener:MovieInteractionListener): BaseAdapter<Movie>(items, listener) {
    override val layoutId: Int = R.layout.item_movie_list
}

class SearchMovieAdapter(items: List<Movie>, listener:MovieInteractionListener): BaseAdapter<Movie>(items, listener) {
    override val layoutId: Int = R.layout.item_search
}

class GenreAdapter(items: List<GenreX>, listener:MovieInteractionListener): BaseAdapter<GenreX>(items, listener) {
    override val layoutId: Int = R.layout.item_genre
}

class GenreListAdapter(items: List<GenreX>, listener:MovieInteractionListener): BaseAdapter<GenreX>(items, listener) {
    override val layoutId: Int = R.layout.item_genre_list
}

class GenreMovieListAdapter(items: List<Movie>, listener:MovieInteractionListener): BaseAdapter<Movie>(items, listener) {
    override val layoutId: Int = R.layout.gerne_movies
}

interface MovieInteractionListener: BaseInteractionListener {
    fun onClickMovie(movie: Movie)
    fun onClickGenre(genre: GenreX)
}