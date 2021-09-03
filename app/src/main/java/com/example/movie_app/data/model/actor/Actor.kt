package com.example.movie_app.data.model.actor


import com.google.gson.annotations.SerializedName

data class Actor(
    @SerializedName("page")
    val page: Int? = null,
    @SerializedName("results")
    val famous: List<Famous>? = null,
    @SerializedName("total_pages")
    val totalPages: Int? = null,
    @SerializedName("total_results")
    val totalResults: Int? = null
)