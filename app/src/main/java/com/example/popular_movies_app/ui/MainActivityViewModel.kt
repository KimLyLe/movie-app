package com.example.popular_movies_app.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.popular_movies_app.model.MovieItem
import com.example.popular_movies_app.model.MovieRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivityViewModel : ViewModel(){

    private val movieRepository = MovieRepository()
    val movie = MutableLiveData<List<MovieItem>>()
    val error = MutableLiveData<String>()

    /**
     * Get a random number trivia from the repository using Retrofit.
     * onResponse if the response is successful populate the [trivia] object.
     * If the call encountered an error then populate the [error] object.
     */
    fun getMovieList(year: String) {
        movieRepository.getMovieItems(year).enqueue(object : Callback<List<MovieItem>> {
            override fun onResponse(call: Call<List<MovieItem>>, response: Response<List<MovieItem>>) {
                if (response.isSuccessful) {
                    var foo = response.body()
                    println("Response $foo")
                }
                else error.value = "An error occurred: ${response.errorBody().toString()}"
            }

            override fun onFailure(call: Call<List<MovieItem>>, t: Throwable) {
                error.value = t.message
            }
        })
    }
}
