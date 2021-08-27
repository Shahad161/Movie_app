package com.example.movie_app.data.model.genre


import com.google.gson.annotations.SerializedName

data class GenreX(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null
)