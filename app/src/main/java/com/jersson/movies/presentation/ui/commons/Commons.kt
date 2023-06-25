package com.jersson.movies.presentation.ui.commons

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.moviesolera.presentation.ui.navigation.MoviesNavigation

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomBarScreen(
        route = MoviesNavigation.MoviesList.route,
        title = "Lista",
        icon = Icons.Default.List
    )

    object Profile : BottomBarScreen(
        route = MoviesNavigation.MoviesFavorite.route,
        title = "Favoritos",
        icon = Icons.Default.Favorite
    )
}