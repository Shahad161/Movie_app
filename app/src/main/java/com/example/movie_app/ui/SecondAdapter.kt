package com.example.movie_app.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movie_app.R
import com.example.movie_app.data.model.Movie
import com.example.movie_app.data.model.genre.GenreX
import com.example.movie_app.databinding.ItemGenreBinding
import java.lang.Exception


class SecondAdapter(private var items: List<GenreX>, private val listener: MovieInteractionListener):
    RecyclerView.Adapter<SecondAdapter.GenreViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        return when(viewType){
            VIEW_TYPE_GENRE -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_genre, parent, false)
                GenreViewHolder(view)
            }
            else -> throw Exception("UNKNOWN VIEW TYPE")
        }
    }

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
      val currentItem = items[position]
        holder.binding.item = currentItem
        holder.binding.listener = listener
    }


    override fun getItemViewType(position: Int): Int {
        return VIEW_TYPE_GENRE
    }


    override fun getItemCount() = items.size


    abstract class BaseCategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    class GenreViewHolder(itemView: View) : BaseCategoryViewHolder(itemView) {
        val binding = ItemGenreBinding.bind(itemView)

    }

    companion object{
        private const val VIEW_TYPE_GENRE = 1
    }
}

interface GenreInteractionListener{
    fun onClickGenre(movie: Movie)
}