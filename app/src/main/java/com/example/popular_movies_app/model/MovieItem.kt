package com.example.popular_movies_app.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class MovieItem (
    @SerializedName("title")var title: String,
    @SerializedName("title")var year: Int,
    @SerializedName("content")var content: String,
    @SerializedName("cover")var cover: String,
    @SerializedName("background")var background: String,
    @SerializedName("releaseDate")var releaseDate: Date,
    @SerializedName("rating")var rating: Double
    ) {

    fun getCoverForMovie() =
        "https://image.tmdb.org/t/p/w500/$cover"

    fun getBackgroundForMovie() =
        "https://image.tmdb.org/t/p/w500/$background"
}