package com.example.movie_app.data.model.cast


import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@SuppressLint("ParcelCreator")
data class Cast(
    @SerializedName("cast")
    val cast: List<CastX>? = null,
    @SerializedName("crew")
    val crew: List<Crew>? = null,
    @SerializedName("id")
    val id: Int? = null
): Parcelable {
    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        TODO("Not yet implemented")
    }
}