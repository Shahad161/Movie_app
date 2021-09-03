package com.example.movie_app.data.tv


import com.google.gson.annotations.SerializedName

data class Tv(
    @SerializedName("page")
    val page: Int? = null,
    @SerializedName("results")
    val results: List<Result>? = null,
    @SerializedName("total_pages")
    val totalPages: Int? = null,
    @SerializedName("total_results")
    val totalResults: Int? = null
)