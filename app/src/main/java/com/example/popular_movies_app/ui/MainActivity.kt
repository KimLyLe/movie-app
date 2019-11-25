package com.example.popular_movies_app.ui
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.popular_movies_app.R
import com.example.popular_movies_app.model.MovieAdapter
import com.example.popular_movies_app.model.MovieItem
import com.example.popular_movies_app.model.MovieRepository
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.movie_item.*


class MainActivity : AppCompatActivity() {

    private val movies = arrayListOf<MovieItem>()
    private val movieAdapter = MovieAdapter(movies) { movieItem -> onMovieClick(movieItem) }
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbarMain)
        initViews()
        initViewModel()
    }

    private fun initViews() {
        rvMovies.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        rvMovies.adapter = movieAdapter
        btnSubmit.setOnClickListener{
            val yearInput = editText.text.toString()
            viewModel.getMovieList(yearInput)
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        viewModel.movie.observe(this, Observer { movieItem ->
            this.movies.clear()
            this.movies.addAll(movieItem)
            movieAdapter.notifyDataSetChanged()
        })
    }

    private fun onMovieClick(movieItem: MovieItem) {
        Snackbar.make(rvMovies, "This movie is: ${movieItem.releaseDate}", Snackbar.LENGTH_LONG).show()
    }
}

