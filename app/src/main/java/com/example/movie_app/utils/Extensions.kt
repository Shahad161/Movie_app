package com.example.movie_app.utils

import androidx.lifecycle.MutableLiveData
import com.example.movie_app.data.domain.HomeItem
import com.example.movie_app.data.domain.HomeItemType
import com.example.movie_app.data.model.Movie

fun Movie.toItem(): HomeItem<Any>{
    return HomeItem(this, HomeItemType.TYPE_POPULAR)
}

fun <T> MutableLiveData<T>.notifyObserver() {
    this.value = this.value
}