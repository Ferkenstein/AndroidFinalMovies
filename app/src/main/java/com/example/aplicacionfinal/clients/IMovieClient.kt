package com.example.aplicacionfinal.clients
import com.example.aplicacionfinal.models.Movie
import com.example.aplicacionfinal.models.MovieList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IMovieClient {
    @GET("/3/movie/{id}?api_key=b1f126157f537273ff8cd8b94da6313a")
    fun details(@Path("id") detailsId: Int): Call<Movie>

    @GET("/3/movie/popular?api_key=b1f126157f537273ff8cd8b94da6313a&language=en-US&page=1")
    fun popularDetails(): Call<MovieList>

    @GET("/3/search/movie?api_key=b1f126157f537273ff8cd8b94da6313a&language=en-US&page=1&include_adult=false")
    fun search(@Query("query") searchName: String?): Call<MovieList>

}