package com.example.popular_movies_app.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.time.LocalDate

@Parcelize
data class MovieItem (
    @SerializedName("poster_path")var cover: String,
    @SerializedName("backdrop_path")var background: String,
    @SerializedName("title")var title: String,
    @SerializedName("vote_average")var vote: String,
    @SerializedName("release_date")var releaseDate: String,
    @SerializedName("overview")var content: String
) : Parcelable