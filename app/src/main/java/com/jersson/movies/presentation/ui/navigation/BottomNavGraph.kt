package com.jersson.movies.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jersson.movies.presentation.ui.favorite.FavoriteScreen
import com.jersson.movies.presentation.ui.list.ListScreen
import com.example.moviesolera.presentation.ui.navigation.MoviesNavigation
import com.jersson.movies.presentation.ui.MoviesViewModel
import com.jersson.movies.presentation.ui.model.MoviesState

@Composable
fun BottomNavGraph(
    navController: NavHostController,
    viewModel: MoviesViewModel,
    onClick: (() -> Unit? )? = null
) {

    NavHost(
        navController = navController,
        startDestination = MoviesNavigation.MoviesList.route
    ) {
        composable(route = MoviesNavigation.MoviesList.route) {
            ListScreen(
                state = viewModel.state.value,
                onClick = onClick
            )
        }
        composable(route = MoviesNavigation.MoviesFavorite.route) {
            FavoriteScreen(
                state = viewModel.state.value
            )
        }
    }
}