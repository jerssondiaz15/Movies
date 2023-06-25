package com.jersson.movies.data.movie.local.model.mapper

import com.jersson.movies.data.movie.local.model.DbMovie
import com.jersson.movies.presentation.ui.model.MoviesState

fun List<DbMovie>.toListMovie(): List<MoviesState.Movie> = this.map { it.toMovie() }
fun DbMovie.toMovie(): MoviesState.Movie = with(this){
    MoviesState.Movie(
        id = id,
        backdropPath = backdropPath,
        originalLanguage = originalLanguage,
        coin = coin,
        synopsis = synopsis,
        posterPath = posterPath,
        releaseDate = releaseDate,
        title = title,
        voteAverage = voteAverage,
        isFavorite = isFavorite ?: true
    )
}

fun List<MoviesState.Movie>.toDbMovie(): List<DbMovie> = this.map { it.toDbMovie() }
fun MoviesState.Movie.toDbMovie(): DbMovie = with(this){
    DbMovie(
        id = id,
        backdropPath = backdropPath,
        originalLanguage = originalLanguage,
        coin = coin,
        synopsis = synopsis,
        posterPath = posterPath,
        releaseDate = releaseDate,
        title = title,
        voteAverage = voteAverage,
        isFavorite = isFavorite
    )
}