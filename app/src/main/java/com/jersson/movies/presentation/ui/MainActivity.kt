package com.jersson.movies.presentation.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.jersson.movies.presentation.ui.commons.MOVIE_EXTRAS
import com.jersson.movies.presentation.ui.detail.DetailActivity
import com.jersson.movies.presentation.ui.home.HomeScreen
import com.jersson.movies.presentation.ui.theme.MoviesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val moviesViewModel by viewModels<MoviesViewModel>()
        setContent {
            MoviesTheme {
                HomeScreen(
                    moviesViewModel = moviesViewModel,
                    onClick = {
                        val intent = Intent(this, DetailActivity::class.java)
                        intent.putExtra(MOVIE_EXTRAS, it)
                        startActivity(intent)
                    }
                )
            }
        }
    }
}