package com.jersson.movies.data.movie.local

import com.jersson.movies.data.movie.local.datasource.MovieDatabaseDataSource
import com.jersson.movies.data.movie.local.model.mapper.toDbMovie
import com.jersson.movies.data.movie.local.model.mapper.toListMovie
import com.jersson.movies.domain.repository.IMovieRepository
import com.jersson.movies.presentation.ui.model.MoviesState
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieDatabaseDataSource: MovieDatabaseDataSource
): IMovieRepository {

    override suspend fun getListMovie(): List<MoviesState.Movie> {
        return movieDatabaseDataSource.getListDbMovie().toListMovie()
    }

    override suspend fun deleteAllMovies() {
        movieDatabaseDataSource.deleteAllMovies()
    }

    override suspend fun insertMovies(movie: MoviesState.Movie) {
        movieDatabaseDataSource.insertMovies(movie.toDbMovie())
    }

    override suspend fun getListFavorite(): List<MoviesState.Movie> {
        return movieDatabaseDataSource.getListFavorite().toListMovie()
    }

    override suspend fun updateMovie(isFavorite: Boolean, id: Int) {
        movieDatabaseDataSource.updateMovie(isFavorite, id)
    }

}