package com.example.moviesolera.presentation.ui.navigation

sealed class MoviesNavigation(val route: String){
    object MoviesList: MoviesNavigation("movies_list")
    object MoviesFavorite: MoviesNavigation("movies_favorite")
}