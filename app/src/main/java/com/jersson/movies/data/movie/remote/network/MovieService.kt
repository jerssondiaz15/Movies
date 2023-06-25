package com.jersson.movies.data.movie.remote.network

import android.util.Log
import com.jersson.movies.data.movie.remote.model.ListMovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieService @Inject constructor(
    private val api: MovieApiClient
) {

    suspend fun getListMovies(): ListMovieResponse? {
        return withContext(Dispatchers.IO){
            val response = api.getListMovies(API_KEY)
            Log.e("List: ", response.body().toString())
            response.body()
        }
    }
}

const val API_KEY = "f46b58478f489737ad5a4651a4b25079"