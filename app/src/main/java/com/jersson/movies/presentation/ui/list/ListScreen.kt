package com.jersson.movies.presentation.ui.list

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jersson.movies.R
import com.jersson.movies.presentation.ui.model.MoviesState
import com.jersson.movies.presentation.ui.theme.movieHeadboard

@Composable
fun ListScreen(
    state: MoviesState = MoviesState(),
    onClick: ((MoviesState.Movie) -> Unit? )? = null
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        AnimatedVisibility(
            visibleState = MutableTransitionState(true),
            enter = expandHorizontally(),
            exit = shrinkHorizontally()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = stringResource(id = R.string.our_billboard),
                    style = movieHeadboard
                )
                LazyColumn {
                    items(items = state.listMovies){ movie ->
                        MoviesItem(
                            movie = movie,
                            onClick = {
                                onClick?.invoke(movie)
                            },
                            onFavorite = {
                                state.funtionMovie.onFavorite?.invoke(movie)
                            }
                        )
                    }
                }
            }
        }
    }
}