package com.jersson.movies.data.movie.remote

import com.jersson.movies.data.movie.remote.model.mapper.toListMovie
import com.jersson.movies.data.movie.remote.network.MovieService
import com.jersson.movies.presentation.ui.model.MoviesState
import javax.inject.Inject

class MovieRemoteRepository @Inject constructor(
    private val api: MovieService
) {

    suspend fun getListMovies(): List<MoviesState.Movie>? {
        val response = api.getListMovies()
        return response?.listMovies?.toListMovie()
    }

}