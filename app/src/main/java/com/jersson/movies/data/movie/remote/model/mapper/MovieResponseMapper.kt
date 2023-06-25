package com.jersson.movies.data.movie.remote.model.mapper

import com.jersson.movies.data.movie.remote.model.MovieResponse
import com.jersson.movies.presentation.ui.model.MoviesState

fun List<MovieResponse>.toListMovie(): List<MoviesState.Movie> = this.map { it.toMovie() }
fun MovieResponse.toMovie(): MoviesState.Movie = with(this){
    MoviesState.Movie(
        id = id,
        backdropPath = backdropPath,
        originalLanguage = originalLanguage,
        coin = coin,
        synopsis = synopsis,
        posterPath = posterPath,
        releaseDate = releaseDate,
        title = title,
        voteAverage = voteAverage
    )
}