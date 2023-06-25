package com.jersson.movies.presentation.ui.model

data class MoviesState(
    val listMovies: List<Movie> = listOf(),
    val listFavorite: List<Movie> = listOf(),
    val movieSelected: Movie = Movie(),
    val navigate: NavigationMovies = NavigationMovies(),
    val funtionMovie: FuntionMovie = FuntionMovie()
) {
    data class Movie(
        val id: Int = 1,
        val backdropPath: String? = "",
        val originalLanguage: String? = "",
        val coin: String? = "",
        val synopsis: String? = "",
        val posterPath: String? = "",
        val releaseDate: String? = "",
        val title: String? = "",
        val voteAverage: Double? = 0.0,
        var isFavorite: Boolean = false
    )

    data class NavigationMovies(
        val goToDetail: (() -> Unit)? = null,
    )

    data class FuntionMovie(
        val movieSelected: ((Movie) -> Unit)? = null,
        val onFavorite: ((Movie) -> Unit)? = null
    )
}