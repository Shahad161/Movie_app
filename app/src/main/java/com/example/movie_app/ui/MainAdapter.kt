package com.example.movie_app.ui

import android.view.animation.AnimationUtils
import com.example.movie_app.R
import com.example.movie_app.data.model.Movie
import com.example.movie_app.data.model.actor.Famous
import com.example.movie_app.data.model.actor.KnownFor
import com.example.movie_app.data.model.genre.GenreX
import com.example.movie_app.data.movieDetails.Genre
import com.example.movie_app.data.tv.Result

class PopularMovieAdapter(items: List<Movie>, listener:MovieInteractionListener): BaseAdapter<Movie>(items, listener) {
    override val layoutId: Int = R.layout.item_movie

}

class SearchMovieAdapter(items: List<Movie>, listener:MovieInteractionListener): BaseAdapter<Movie>(items, listener) {
    override val layoutId: Int = R.layout.item_search
}

class GenreAdapter(items: List<GenreX>, listener:MovieInteractionListener): BaseAdapter<GenreX>(items, listener) {
    override val layoutId: Int = R.layout.item_genre
}

class GenreListAdapter(items: List<GenreX>, listener:MovieInteractionListener): BaseAdapter<GenreX>(items, listener) {
    override val layoutId: Int = R.layout.item_genre_list
    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.itemView.animation = AnimationUtils.loadAnimation(holder.itemView.context, R.anim.cards_anim)
    }
}

class GenreMovieListAdapter(items: List<Movie>, listener:MovieInteractionListener): BaseAdapter<Movie>(items, listener) {
    override val layoutId: Int = R.layout.gerne_movies
    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.itemView.animation = AnimationUtils.loadAnimation(holder.itemView.context, R.anim.cards_anim)
    }
}

class GenreForEachMovieAdapter(items: List<Genre>, listener:MovieInteractionListener): BaseAdapter<Genre>(items, listener) {
    override val layoutId: Int = R.layout.item_genre_for_each_movie
}

class AllTVAdapter(items: List<Result>, listener:MovieInteractionListener): BaseAdapter<Result>(items, listener) {
    override val layoutId: Int = R.layout.all_tv
}
class PopularPersonAdapter(items: List<Famous>, listener:MovieInteractionListener): BaseAdapter<Famous>(items, listener) {
    override val layoutId: Int = R.layout.item_actor

}

class ActorsMoviesAdapter(items: List<KnownFor>, listener:MovieInteractionListener): BaseAdapter<KnownFor>(items, listener) {
    override val layoutId: Int = R.layout.item_actors_movies
}

class SimilarMoviesAdapter(items: List<Movie>, listener:MovieInteractionListener): BaseAdapter<Movie>(items, listener) {
    override val layoutId: Int = R.layout.item_similar
}


class TrendingAdapter(items: List<Movie>, listener:MovieInteractionListener): BaseAdapter<Movie>(items, listener) {
    override val layoutId: Int = R.layout.trending_item
    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.itemView.animation = AnimationUtils.loadAnimation(holder.itemView.context, R.anim.cards_anim)
    }

}

interface MovieInteractionListener: BaseInteractionListener {
    fun onClickMovie(movie: Movie)
    fun onClickGenre(genre: GenreX)
    fun onClickFamous(famous: Famous)
}