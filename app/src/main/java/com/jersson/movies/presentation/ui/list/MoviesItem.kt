package com.jersson.movies.presentation.ui.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.jersson.movies.R
import com.jersson.movies.presentation.ui.utils.convertDate
import com.jersson.movies.presentation.ui.commons.URL_IMAGE
import com.jersson.movies.presentation.ui.commons.getFavoriteVector
import com.jersson.movies.presentation.ui.model.MoviesState
import com.jersson.movies.presentation.ui.theme.movieDetail
import com.jersson.movies.presentation.ui.theme.movieHeadboard

@Preview
@Composable
fun MoviesItem(
    movie: MoviesState.Movie = MoviesState.Movie(),
    onClick: ((MoviesState.Movie) -> Unit? )? = null,
    onFavorite: ((MoviesState.Movie) -> Unit? )? = null
){
    Column(
        modifier = Modifier.clickable {
            onClick?.invoke(movie)
        }
    ) {
        Box(
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 16.dp)
                .background(color = Color.White)
                .border(
                    width = 2.dp,
                    color = Color.Black
                )
        ) {
            Row(
                modifier = Modifier
                    .padding(all = 2.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .width(100.dp)
                        .height(120.dp)
                        .weight(1f),
                    painter = rememberAsyncImagePainter(model = "$URL_IMAGE${movie.posterPath}"),
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.height(10.dp))
                Column(
                    modifier = Modifier
                        .weight(2f)
                ) {
                    Text(
                        text = movie.title ?: stringResource(id = R.string.no_tittle),
                        style = movieHeadboard,
                        maxLines = 1
                    )
                    Text(
                        text = convertDate(movie.releaseDate ?: stringResource(id = R.string.example_date)),
                        style = movieDetail,
                        maxLines = 1
                    )
                    Text(
                        text = "${stringResource(id = R.string.calify)} ${movie.voteAverage}",
                        style = movieDetail,
                        maxLines = 1
                    )
                }
                IconButton(
                    onClick = { 
                        onFavorite?.invoke(movie)
                    }
                ) {
                    Icon(
                        modifier = Modifier
                            .weight(0.5f),
                        painter = painterResource(id = getFavoriteVector(movie.isFavorite)),
                        contentDescription = "",
                        tint = Color.Red
                    )
                }
            }
        }
    }
}