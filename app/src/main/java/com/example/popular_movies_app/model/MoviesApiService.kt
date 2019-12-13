package com.example.popular_movies_app.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApiService {

    // The GET method needs to retrieve the movies published in the given year
    @GET("movie?api_key=f896fbd8b02afe7da46fd7cdac552d39&language=en-US&sort_by=popularity.desc")
    fun getMovieItems(@Query(value="year", encoded=true) year: Int): Call<MovieList>
}

