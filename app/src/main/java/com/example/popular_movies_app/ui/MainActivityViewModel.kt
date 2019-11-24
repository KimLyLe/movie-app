package com.example.popular_movies_app.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.popular_movies_app.model.MovieItem
import com.example.popular_movies_app.model.MovieRepository


class MainActivityViewModel : ViewModel(){
    private val movieRepository = MovieRepository()
    val movieItems = MutableLiveData<List<MovieItem>>().apply {
        value = movieRepository.getMovieItems()
    }
}
