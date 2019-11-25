package com.example.popular_movies_app.model

import com.google.gson.annotations.SerializedName
import java.time.LocalDate

data class MovieItem (
    @SerializedName("title")var title: String,
    @SerializedName("year")var year: Int,
    @SerializedName("content")var content: String,
    @SerializedName("cover")var cover: String,
    @SerializedName("background")var background: String,
    @SerializedName("releaseDate")var releaseDate: LocalDate,
    @SerializedName("rating")var rating: Double
    ) {



    fun getCoverForMovie() =
        "https://image.tmdb.org/t/p/w500/$cover"

    fun getBackgroundForMovie() =
        "https://image.tmdb.org/t/p/w500/$background"
}