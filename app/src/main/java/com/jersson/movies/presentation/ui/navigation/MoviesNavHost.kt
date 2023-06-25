package com.jersson.movies.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.moviesolera.presentation.ui.navigation.MoviesNavigation
import com.jersson.movies.presentation.ui.MoviesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoviesNavHost(
    viewModel: MoviesViewModel = hiltViewModel()
){
    val navController = rememberNavController()

    Scaffold() {
        NavHost(
            navController = navController,
            startDestination = MoviesNavigation.MoviesList.route
        ) {
            moviesGraph(
                state = {
                    viewModel.state.value
                }
            )
        }
    }
}