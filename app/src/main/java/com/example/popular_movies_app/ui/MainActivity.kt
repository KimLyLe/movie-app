package com.example.popular_movies_app.ui
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.popular_movies_app.R
import com.example.popular_movies_app.model.MovieAdapter
import com.example.popular_movies_app.model.MovieItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity() {

    private val movies = arrayListOf<MovieItem>()
    private val movieAdapter = MovieAdapter(movies) { onMovieClick() }
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbarMain)
        initViews()
        initViewModel()
    }

    private fun initViews() {
        btnSubmit.setOnClickListener{
            val yearInput = Integer.parseInt(editText.text.toString())
            viewModel.getMovieList(yearInput)
        }
        rvMovies.layoutManager = GridLayoutManager(this,2)
        rvMovies.adapter = movieAdapter
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        viewModel.movie.observe(this, Observer {
            movies.clear()
            movies.addAll(viewModel.movie.value!!.resultsList)
            movieAdapter.notifyDataSetChanged()
        })
    }

    private fun onMovieClick() {
        val intent = Intent(this, Movie_details_activity::class.java)
        startActivity(intent)
    }
}

