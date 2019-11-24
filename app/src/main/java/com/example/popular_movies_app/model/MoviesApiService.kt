package com.example.popular_movies_app.model

import retrofit2.Call
import retrofit2.http.GET

interface MoviesApiService {

    // The GET method needed to retrieve a random number trivia.
    @GET("/random/trivia?json")
    fun getMovieItems(): Call<List<MovieItem>>
}