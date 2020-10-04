package com.example.aplicacionfinal.services
import com.example.aplicacionfinal.models.Movie
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface IMovieService {
    @GET("/3/movie/550?api_key=b1f126157f537273ff8cd8b94da6313a")
    fun details(): Call<Movie>
}