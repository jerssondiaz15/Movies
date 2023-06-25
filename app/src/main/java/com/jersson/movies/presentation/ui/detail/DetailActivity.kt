package com.jersson.movies.presentation.ui.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.jersson.movies.presentation.ui.commons.MOVIE_EXTRAS
import com.jersson.movies.presentation.ui.model.MoviesState

class DetailActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val movie = intent.getParcelableExtra<MoviesState.Movie>(MOVIE_EXTRAS)
        setContent {
            DetailScreen(
                movie = movie ?: MoviesState.Movie()
            )
        }
    }
}