package com.example.movie_app.data.movieDetails


import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import com.example.movie_app.data.model.cast.CastX
import com.example.movie_app.data.model.cast.Crew
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@SuppressLint("ParcelCreator")
data class MovieDetails(
    @SerializedName("adult")
    val adult: Boolean? = null,
    @SerializedName("backdrop_path")
    val backdropPath: String? = null,
    @SerializedName("belongs_to_collection")
    val belongsToCollection: BelongsToCollection? = null,
    @SerializedName("budget")
    val budget: Int? = null,
    @SerializedName("genres")
    val genres: List<Genre>? = null,
    @SerializedName("homepage")
    val homepage: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("imdb_id")
    val imdbId: String? = null,
    @SerializedName("original_language")
    val originalLanguage: String? = null,
    @SerializedName("original_title")
    val originalTitle: String? = null,
    @SerializedName("overview")
    val overview: String? = null,
    @SerializedName("popularity")
    val popularity: Double? = null,
    @SerializedName("poster_path")
    var posterPath: String,
    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompany>? = null,
    @SerializedName("production_countries")
    val productionCountries: List<ProductionCountry>? = null,
    @SerializedName("release_date")
    val releaseDate: String? = null,
    @SerializedName("revenue")
    val revenue: Int? = null,
    @SerializedName("runtime")
    val runtime: Int? = null,
    @SerializedName("spoken_languages")
    val spokenLanguages: List<SpokenLanguage>? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("tagline")
    val tagline: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("video")
    val video: Boolean? = null,
    @SerializedName("vote_average")
    val voteAverage: Double? = null,
    @SerializedName("vote_count")
    val voteCount: Int? = null,
    ): Parcelable{
    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        TODO("Not yet implemented")
    }
}