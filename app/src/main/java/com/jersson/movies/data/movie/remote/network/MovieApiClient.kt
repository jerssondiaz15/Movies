package com.jersson.movies.data.movie.remote.network

import com.jersson.movies.data.movie.remote.model.ListMovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiClient {

    @GET("popular")
    suspend fun getListMovies(
        @Query("api_key") apiKey: String
    ): Response<ListMovieResponse>
}