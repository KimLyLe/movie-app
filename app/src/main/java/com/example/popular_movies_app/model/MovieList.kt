package com.example.popular_movies_app.model

import com.google.gson.annotations.SerializedName

data class MovieList (
    @SerializedName("results")var resultsList: List<MovieItem>
    )