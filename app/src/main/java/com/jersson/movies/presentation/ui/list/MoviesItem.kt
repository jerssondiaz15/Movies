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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.jersson.movies.presentation.ui.commons.getFavoriteVector
import com.jersson.movies.presentation.ui.model.MoviesState
import com.jersson.movies.presentation.ui.theme.movieDetail
import com.jersson.movies.presentation.ui.theme.movieTittle

@Preview
@Composable
fun MoviesItem(
    movie: MoviesState.Movie = MoviesState.Movie(),
    onClick: ((MoviesState.Movie) -> Unit? )? = null
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
                    //painter = painterResource(id = R.drawable.ic_launcher_background),
                    painter = rememberAsyncImagePainter(model = "https://image.tmdb.org/t/p/w500//3IhGkkalwXguTlceGSl8XUJZOVI.jpg"),
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.height(10.dp))
                Column(
                    modifier = Modifier
                        .weight(2f)
                ) {
                    Text(
                        text = movie.title,
                        style = movieTittle,
                        maxLines = 1
                    )
                    Text(
                        text = "24 de Junio del 2023",
                        style = movieDetail,
                        maxLines = 1
                    )
                    Text(
                        text = "Calificación: ${movie.voteAverage}",
                        style = movieDetail,
                        maxLines = 1
                    )
                }
                IconButton(
                    onClick = { 
                        
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