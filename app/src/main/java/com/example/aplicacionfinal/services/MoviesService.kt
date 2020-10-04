package com.example.aplicacionfinal.services

import com.example.aplicacionfinal.clients.IMovieClient
import com.example.aplicacionfinal.models.Movie
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MoviesService {

    lateinit var client:IMovieClient

    init {
        val API_BASE_URL = "https://api.themoviedb.org/"

        val httpClient = OkHttpClient.Builder()

        val builder = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            )

        val retrofit = builder
            .client(
                httpClient.build()
            )
            .build()

        this.client = retrofit.create(IMovieClient::class.java)
    }

    fun getDetails(callback: (movie: Movie) -> Unit) {
        var call = this.client.details()
        call.enqueue(object: Callback<Movie> {
            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                if (response.isSuccessful()){
                    callback(response.body()!!)
                }
            }
            override fun onFailure(call: Call<Movie>?, t: Throwable?) {
                throw t!!
            }
        })
    }
}