package com.jersson.movies.domain.test

import com.jersson.movies.presentation.ui.model.MoviesState

object Data {
    val listMovies = listOf(
        MoviesState.Movie(
            id = 1,
            backdropPath = "",
            originalLanguage = "",
            coin = "",
            synopsis = "",
            posterPath = "",
            releaseDate = "",
            title = "",
            voteAverage = 0.0,
            isFavorite = true
        )
    )
}