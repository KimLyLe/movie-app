package com.example.popular_movies_app.model

class MovieRepository {

    private val moviesApi: MoviesApiService = MoviesApi.createApi()


    fun getMovieItems(year: Int) = moviesApi.getMovieItems(year)
}

