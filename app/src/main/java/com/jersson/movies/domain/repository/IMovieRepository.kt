package com.jersson.movies.domain.repository

import com.jersson.movies.presentation.ui.model.MoviesState


interface IMovieRepository {

    suspend fun getListMovie(): List<MoviesState.Movie>
    suspend fun deleteAllMovies()
    suspend fun insertMovies(movie: MoviesState.Movie)

}