package com.example.aplicacionfinal.services

import com.example.aplicacionfinal.clients.IMovieClient
import com.example.aplicacionfinal.models.Movie
import com.example.aplicacionfinal.models.MovieList
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MoviesService {

    var client:IMovieClient

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

    fun getDetails(callback: (movie: Movie) -> Unit, idMovie:Int) {
        var call = this.client.details(idMovie)
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

    fun getPopularDetails(callback: (movie: MovieList) -> Unit) {
        var call = this.client.popularDetails()
        call.enqueue(object: Callback<MovieList> {
            override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
                if (response.isSuccessful()){
                    callback(response.body()!!)
                }
            }
            override fun onFailure(call: Call<MovieList>?, t: Throwable?) {
                throw t!!
            }
        })
    }

    fun getSearch(callback: (movieList: MovieList) -> Unit, searchName:String) {
        var call = this.client.search(searchName)
        call.enqueue(object: Callback<MovieList> {
            override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
                if (response.isSuccessful()){
                    callback(response.body()!!)
                }
            }
            override fun onFailure(call: Call<MovieList>?, t: Throwable?) {
                throw t!!
            }
        })
    }
}