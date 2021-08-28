package com.example.movie_app.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movie_app.BR
import com.example.movie_app.R
import com.example.movie_app.data.domain.HomeItem
import com.example.movie_app.data.domain.HomeItemType
import com.example.movie_app.data.model.Movie
import com.example.movie_app.data.model.genre.GenreX
import com.example.movie_app.databinding.ItemGenreBinding
import com.example.movie_app.databinding.ItemMovieBinding
import java.lang.Exception

class HomeMovieAdapter(private var items: List<HomeItem<Any>>, private val listener:MovieInteractionListener):
    RecyclerView.Adapter<HomeMovieAdapter.BaseHomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHomeViewHolder {
        return when(viewType){
            VIEW_TYPE_GENRE -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_genre_list, parent, false)
                GenreViewHolder(view)
            }
            VIEW_TYPE_MOVIE -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
                MovieViewHolder(view)
            }
            else -> throw Exception("UNKNOWN VIEW TYPE")
        }
    }

    override fun onBindViewHolder(holder: BaseHomeViewHolder, position: Int) {
        when(holder){
            is MovieViewHolder -> bindMovie(holder, position)
            is GenreViewHolder -> bindGenre(holder, position)
        }
    }

    private fun bindMovie(holder: MovieViewHolder, position: Int){
        val currentItem = items[position].item as Movie
        when(holder){
            is MovieViewHolder -> {
                holder.binding.setVariable(BR.item, currentItem)
                holder.binding.setVariable(BR.listener, listener)
            }
        }
    }
    private fun bindGenre(holder: GenreViewHolder, position: Int){
        val currentItem = items[position].item as GenreX
        when(holder){
            is GenreViewHolder -> {
                holder.binding.setVariable(BR.item, currentItem)
                holder.binding.setVariable(BR.listener, listener)
            }
        }
    }

    fun setItem(newItem: List<HomeItem<Any>>?) {
        items = newItem!!
    }

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int): Int {
        return when(items[position].type){
            HomeItemType.TYPE_POPULAR -> VIEW_TYPE_MOVIE
            HomeItemType.TYPE_GENRE -> VIEW_TYPE_GENRE
            HomeItemType.TYPE_TOP_RATE -> TODO()
        }
    }


    abstract class BaseHomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    class MovieViewHolder(itemView: View) : BaseHomeViewHolder(itemView){
        val binding = ItemMovieBinding.bind(itemView)
    }
    class GenreViewHolder(itemView: View) : BaseHomeViewHolder(itemView) {
        val binding = ItemGenreBinding.bind(itemView)

    }

    companion object {
        private const val VIEW_TYPE_MOVIE = 2
        private const val VIEW_TYPE_GENRE = 1
    }

}

interface MovieInteractionListener{
    fun onClickMovie(movie: Movie)
}