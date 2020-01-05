package com.example.popular_movies_app.ui
import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.popular_movies_app.R
import com.example.popular_movies_app.model.MovieAdapter
import com.example.popular_movies_app.model.MovieItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity() {

    private val movies = arrayListOf<MovieItem>()
    private val movieAdapter = MovieAdapter(movies, onClick = {onMovieClick(it)})
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var progressBar: ProgressBar


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
        progressBar = ProgressBar(this)
        val layoutParameters = RelativeLayout.LayoutParams(100, 100)
        layoutParameters.addRule(RelativeLayout.CENTER_IN_PARENT)
        content_main.addView(progressBar, layoutParameters)
        rvMovies.layoutManager = GridLayoutManager(this,2)
        rvMovies.adapter = movieAdapter
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        viewModel.movie.observe(this, Observer {
            movies.clear()
            movies.addAll(it)
            movieAdapter.notifyDataSetChanged()
        })

        viewModel.isLoading.observe(this, Observer {
            if (it) {
                progressBar.visibility = ProgressBar.VISIBLE
            } else {
                progressBar.visibility = ProgressBar.GONE
            }
        })
    }

    private fun onMovieClick(movieItem: MovieItem) {
        val intent = Intent(this, Movie_details_activity::class.java)
        val bundle = Bundle()
        bundle.putParcelable("MovieItem", movieItem)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}

