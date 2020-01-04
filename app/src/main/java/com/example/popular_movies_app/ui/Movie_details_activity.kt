package com.example.popular_movies_app.ui

import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.popular_movies_app.R
import com.example.popular_movies_app.model.MovieItem
import com.example.popular_movies_app.model.MoviesApi

import kotlinx.android.synthetic.main.activity_movie_details.*
import kotlinx.android.synthetic.main.content_movie_details.*
import java.lang.Exception

class Movie_details_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        initViews()
    }

    private fun initViews() {
        supportActionBar?.hide()
        val movie = intent.extras
        if(movie != null){
            val movie: MovieItem = movie.get("MovieItem") as MovieItem
            Glide.with(this).load(MoviesApi.imageUrl + movie.background).into(imageView)
            Glide.with(this).load(MoviesApi.imageUrl + movie.cover).into(imageView3)
            tvMovieTitle.text = movie.title
            tvReleaseDate.text = movie.releaseDate
            tvRating.text = movie.vote
            tvMovieContent.text = movie.content
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return try {
            finish()
            true
        } catch (e: Exception) {
            false
        }
    }
}
