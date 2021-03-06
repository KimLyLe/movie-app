package com.example.popular_movies_app.model

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MoviesApi {
    companion object {
        // The base url off the api.
        const val imageUrl = "https://image.tmdb.org/t/p/w500/"
        private const val baseUrl = "https://api.themoviedb.org/3/discover/"

        /**
         * @return [MoviesApiService] The service class off the retrofit client.
         */
        fun createApi(): MoviesApiService {
            // Create an OkHttpClient to be able to make a log of the network traffic
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()

// Create the Retrofit instance
            val numbersApi = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            // Return the Retrofit NumbersApiService
            return numbersApi.create(MoviesApiService::class.java)
        }
    }
}