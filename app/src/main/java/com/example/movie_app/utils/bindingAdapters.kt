package com.example.movie_app.utils

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movie_app.ui.base.BaseAdapter

@BindingAdapter(value = ["app:showWhenLoading"])
fun <T>showWhenLoading(view: View, state: State<T>?){
    if (state is State.Loading){
        view.visibility = View.VISIBLE
    }else{
        view.visibility = View.GONE
    }
}

@BindingAdapter(value = ["app:showWhenSuccess"])
fun <T>showWhenSuccess(view: View, state: State<T>?){
    if (state is State.Success){
        view.visibility = View.VISIBLE
    }else{
        view.visibility = View.GONE
    }
}

@BindingAdapter(value = ["app:showWhenError"])
fun <T>showWhenError(view: View, state: State<T>?) {
    if (state is State.Error) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}

@BindingAdapter(value = ["app:imageUrl"])
fun setImageFromUrl(view: ImageView, url: String?) {
    val URL = "https://image.tmdb.org/t/p/w500$url"
    Glide.with(view).load(URL).centerCrop().into(view)
}

@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView, items: List<T>?) {
    Log.i("uu", items.toString())
    if (items != null){
        view.adapter?.notifyDataSetChanged()
        (view.adapter as BaseAdapter<T>?)?.setItems(items)
    }else{
        (view.adapter as BaseAdapter<T>?)?.setItems(emptyList())
    }
}
