package com.jersson.movies.presentation.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.jersson.movies.R
import com.jersson.movies.presentation.ui.Utils.convertDate
import com.jersson.movies.presentation.ui.commons.URL_IMAGE
import com.jersson.movies.presentation.ui.model.MoviesState
import com.jersson.movies.presentation.ui.theme.movieDetail
import com.jersson.movies.presentation.ui.theme.movieHeadboard

@Composable
fun DetailScreen(
    movie: MoviesState.Movie
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            painter = rememberAsyncImagePainter(model = "$URL_IMAGE${movie.backdropPath}"),
            contentDescription = ""
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(2f),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = movie.title ?: stringResource(id = R.string.no_tittle),
                style = movieHeadboard,
                textAlign = TextAlign.Center
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
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                modifier = Modifier
                    .padding(
                        horizontal = 10.dp
                    ),
                text = movie.synopsis ?: stringResource(id = R.string.dont_have_synopsis),
                style = movieDetail
            )
        }
    }
}