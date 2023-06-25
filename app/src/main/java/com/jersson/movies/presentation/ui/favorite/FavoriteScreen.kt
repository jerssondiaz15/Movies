package com.jersson.movies.presentation.ui.favorite

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jersson.movies.presentation.ui.model.MoviesState
import com.jersson.movies.presentation.ui.theme.movieHeadboard
import com.jersson.movies.R

@Composable
fun FavoriteScreen(
    state: MoviesState = MoviesState(),
    onClick: ((MoviesState.Movie) -> Unit? )? = null
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedVisibility(
            visibleState = MutableTransitionState(true),
            enter = expandHorizontally(),
            exit = shrinkHorizontally()
        ) {
            if (state.listFavorite.isEmpty()){
                Text(
                    text = stringResource(id = R.string.no_favorites),
                    style = movieHeadboard
                )
            } else{
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = stringResource(id = R.string.your_favorites),
                        style = movieHeadboard
                    )
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2)
                    ){
                        items(items = state.listFavorite){movie ->
                            FavoriteItem(
                                movie = movie,
                                onClick = {
                                    onClick?.invoke(movie)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}