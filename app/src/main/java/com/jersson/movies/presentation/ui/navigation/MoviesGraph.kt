package com.jersson.movies.presentation.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jersson.movies.presentation.ui.favorite.FavoriteScreen
import com.jersson.movies.presentation.ui.list.ListScreen
import com.example.moviesolera.presentation.ui.navigation.MoviesNavigation
import com.jersson.movies.presentation.ui.model.MoviesState

fun NavGraphBuilder.moviesGraph(
    state: () -> MoviesState
){
    navigation(
        startDestination = MoviesNavigation.MoviesList.route,
        route = MoviesNavigation.MoviesList.route
    ) {
        composable(route = MoviesNavigation.MoviesList.route) {
            ListScreen()
        }
        composable(route = MoviesNavigation.MoviesFavorite.route) {
            FavoriteScreen()
        }
    }
}