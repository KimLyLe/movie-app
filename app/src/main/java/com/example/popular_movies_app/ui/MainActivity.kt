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
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*



class MainActivity : AppCompatActivity() {

    private val movies = arrayListOf<MovieItem>()
    private val movieAdapter = MovieAdapter(movies) { movieItem -> onMovieClick(movieItem) }
    private lateinit var viewModel: MainActivityViewModel
    private val movieRepository = MovieRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbarMain)
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        btnSubmit.setOnClickListener{
            val yearInput = editText.text.toString()
            movieRepository.fetchApi(yearInput)
        }

        initViews()
        initViewModel()
    }


    private fun initViews() {
        supportActionBar?.title = "Movie List"
        rvMovies.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        rvMovies.adapter = movieAdapter

    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        viewModel.movieItems.observe(this, Observer {
            movies.clear()
            movies.addAll(it)
            movieAdapter.notifyDataSetChanged()
        })
    }

    private fun onMovieClick(movieItem: MovieItem) {

    }
}

