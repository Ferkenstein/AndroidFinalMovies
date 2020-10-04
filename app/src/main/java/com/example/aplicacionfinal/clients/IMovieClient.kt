package com.example.aplicacionfinal.clients
import com.example.aplicacionfinal.models.Movie
import retrofit2.Call
import retrofit2.http.GET

interface IMovieClient {
    @GET("/3/movie/550?api_key=b1f126157f537273ff8cd8b94da6313a")
    fun details(): Call<Movie>
}