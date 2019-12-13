package com.example.popular_movies_app.model

import com.google.gson.annotations.SerializedName
import java.time.LocalDate


data class MovieItem (
    @SerializedName("poster_path")var cover: String,
    @SerializedName("backdrop_path")var background: String,
    @SerializedName("title")var title: String,
    @SerializedName("vote_average")var vote: String,
    @SerializedName("release_date")var releaseDate: String,
    @SerializedName("overview")var content: String
) {
    fun getCoverForMovie() =
        "https://image.tmdb.org/t/p/w500/$cover"

    fun getBackgroundForMovie() =
        "https://image.tmdb.org/t/p/w500/$background"
}