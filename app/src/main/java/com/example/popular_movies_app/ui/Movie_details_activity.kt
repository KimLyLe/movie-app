package com.example.popular_movies_app.ui

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.popular_movies_app.R
import com.example.popular_movies_app.model.MovieItem

import kotlinx.android.synthetic.main.activity_movie_details.*
import kotlinx.android.synthetic.main.content_movie_details.*

class Movie_details_activity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        setSupportActionBar(toolbar)
        initViews()
    }
    private fun initViews() {
        supportActionBar?.hide()
        val movie = intent.extras
        if(movie != null){
           val movie: MovieItem = movie.get("MovieItem") as MovieItem
        }
    }
}
