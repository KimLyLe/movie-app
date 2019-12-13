package com.example.popular_movies_app.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.popular_movies_app.model.MovieItem
import com.example.popular_movies_app.model.MovieList
import com.example.popular_movies_app.model.MovieRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivityViewModel(application: Application) : AndroidViewModel(application){

    private val movieRepository = MovieRepository()
    val movie = MutableLiveData<List<MovieItem>>()
    val error = MutableLiveData<String>()

    /**
     * Get a random number trivia from the repository using Retrofit.
     * onResponse if the response is successful populate the [trivia] object.
     * If the call encountered an error then populate the [error] object.
     */
    fun getMovieList(year: Int) {
        movieRepository.getMovieItems(year).enqueue(object : Callback<MovieList> {
            override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) =
                if (response.isSuccessful) movie.value = response.body()?.resultsList
                else error.value = "An error occurred: ${response.errorBody().toString()}"

            override fun onFailure(call: Call<MovieList>, t: Throwable) {
                error.value = t.message
            }
        })
    }
}
