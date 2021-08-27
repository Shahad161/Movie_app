package com.example.movie_app.data.model.genre


import com.google.gson.annotations.SerializedName

data class Genre(
    @SerializedName("genres")
    val genres: List<GenreX>? = null
)