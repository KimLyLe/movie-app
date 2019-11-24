package com.example.popular_movies_app.model

import org.json.JSONObject
import java.net.URL
import java.util.*
import java.util.concurrent.Executors

class MovieRepository {

    val movieItemsFromApi = ArrayList<MovieItem>()
    val movieItem = MovieItem("",2019,"", "", "",Date(), 2.6)

    fun fetchApi(year: String) {
        Executors.newSingleThreadExecutor().execute {
            val yearInputAsInt = year.toInt()
            val response = URL(movieForYearUrl(year)).toString()
            val posterPathList = ResponsePosterPath(response).posterPathList?.toTypedArray()
            val backgroundPathList =
                ResponseBackgroundPath(response).backgroundPathList?.toTypedArray()
            val titleList = ResponseTitlePath(response).titleList
            val contentList = ResponseContentPath(response).contentList
            val releaseDateList = ResponseReleaseDatePath(response).releaseDateList
            val votingList = ResponseVotingPath(response).votingList

                if (posterPathList != null) {
                    for (posterPath in posterPathList)
                    movieItem.cover = posterPath.toString()
                }
        }
    }

        private fun movieForYearUrl(year: String) =
            "https://api.themoviedb.org/3/discover/movie?api_key=f896fbd8b02afe7da46fd7cdac552d39&language=en-US&sort_by=popularity.desc&year=$year"

        private fun getImageFromApi(imagePath: String) =
            "https://image.tmdb.org/t/p/w500$imagePath"


        inner class ResponsePosterPath(json: String) : JSONObject(json) {
            val posterPathList = this.optJSONArray("results")
                ?.let { 0.until(it.length()).map { i -> it.optJSONObject(i) } } // returns an array of JSONObject
                ?.map { i -> i.opt("poster_path") }
        }

        inner class ResponseBackgroundPath(json: String) : JSONObject(json) {
            val backgroundPathList = this.optJSONArray("results")
                ?.let { 0.until(it.length()).map { i -> it.optJSONObject(i) } } // returns an array of JSONObject
                ?.map { i -> i.opt("backdrop_path") }
        }

        inner class ResponseTitlePath(json: String) : JSONObject(json) {
            val titleList = this.optJSONArray("results")
                ?.let { 0.until(it.length()).map { i -> it.optJSONObject(i) } } // returns an array of JSONObject
                ?.map { i -> i.opt("title") }
        }

        inner class ResponseContentPath(json: String) : JSONObject(json) {
            val contentList = this.optJSONArray("results")
                ?.let { 0.until(it.length()).map { i -> it.optJSONObject(i) } } // returns an array of JSONObject
                ?.map { i -> i.opt("overview") }
        }

        inner class ResponseReleaseDatePath(json: String) : JSONObject(json) {
            val releaseDateList = this.optJSONArray("results")
                ?.let { 0.until(it.length()).map { i -> it.optJSONObject(i) } } // returns an array of JSONObject
                ?.map { i -> i.opt("release_date") }
        }

        inner class ResponseVotingPath(json: String) : JSONObject(json) {
            val votingList = this.optJSONArray("results")
                ?.let { 0.until(it.length()).map { i -> it.optJSONObject(i) } } // returns an array of JSONObject
                ?.map { i -> i.opt("vote_average") }
        }

    fun getMovieItems(): List<MovieItem> {

        return ArrayList()

    }
}

