package com.jersson.movies.data.movie.local.datasource

import com.jersson.movies.data.movie.local.MovieDataBase
import com.jersson.movies.data.movie.local.model.DbMovie

class MovieDatabaseDataSource(
    private val movieDataBase: MovieDataBase
) {

    suspend fun getListDbMovie(): List<DbMovie> {
        return movieDataBase.movieDao().getListDbMovie()
    }

    suspend fun deleteAllMovies(){
        movieDataBase.movieDao().deleteAllMovies()
    }

    suspend fun insertMovies(dbMovie: DbMovie){
        movieDataBase.movieDao().insertMovies(dbMovie)
    }

    suspend fun getListFavorite(): List<DbMovie> {
        return movieDataBase.movieDao().getListFavorite()
    }

    suspend fun updateMovie(isFavorite: Boolean, id: Int){
        movieDataBase.movieDao().updateMovie(isFavorite, id)
    }
}