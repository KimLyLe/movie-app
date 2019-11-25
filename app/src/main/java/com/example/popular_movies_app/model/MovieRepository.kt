package com.example.popular_movies_app.model

import org.json.JSONObject
import java.net.URL
import java.time.LocalDate
import java.util.*
import java.util.concurrent.Executors

class MovieRepository {

    private val moviesApi: MoviesApiService = MoviesApi.createApi()
    private val movieItemsFromApi = ArrayList<MovieItem>()

    fun fetchApi(year: String) {
        Executors.newSingleThreadExecutor().execute {
            val response = URL(movieForYearUrl(year)).readText()
            val responseArray = Response(response).response?.toTypedArray()

            if (responseArray != null) {
                for (movie in responseArray) {
                    var date = LocalDate.parse("2018-12-12")
                    val foo = MovieItem("", 2019, "", "", "", date, 2.6)
                    foo.title = movie.getString("title")
                    foo.year = year.toInt()
                    movieItemsFromApi.add(foo)
                }
            }
        }
    }

        private fun movieForYearUrl(year: String) =
            "https://api.themoviedb.org/3/discover/movie?api_key=f896fbd8b02afe7da46fd7cdac552d39&language=en-US&sort_by=popularity.desc&year=$year"

        inner class Response(json: String) : JSONObject(json) {
            var date = LocalDate.parse("2018-12-12")
            val foo = MovieItem("", 2019, "", "", "", date, 2.6)
            val response = this.optJSONArray("results")
                ?.let { 0.until(it.length()).map { i -> it.optJSONObject(i) } } // returns an array of JSONObject


        }

    fun getMovieItems(year: String) = moviesApi.getMovieItems(year)
}

