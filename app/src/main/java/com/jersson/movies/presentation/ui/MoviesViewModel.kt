package com.jersson.movies.presentation.ui

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jersson.movies.presentation.ui.model.MoviesState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    @ApplicationContext context: Context
) : ViewModel(){

    private val resources = context.resources

    private var _state = mutableStateOf(MoviesState())
    val state: State<MoviesState> = _state

    private val _listMovies = MutableLiveData<List<MoviesState.Movie>>()
    val listMovies: LiveData<List<MoviesState.Movie>> get() = _listMovies

    init {
        val list = listOf(
            MoviesState.Movie(
                title = "La la land",
                voteAverage = 1.0,
                isFavorite = true
            ),
            MoviesState.Movie(
                title = "La la land",
                voteAverage = 2.0
            ),
            MoviesState.Movie(
                title = "La la land",
                voteAverage = 3.0,
                isFavorite = true
            ),
            MoviesState.Movie(
                title = "La la land",
                voteAverage = 4.0
            ),
            MoviesState.Movie(
                title = "La la land",
                voteAverage = 5.0,
                isFavorite = true
            )
        )
        _state.value = state.value.copy(
            listMovies = list
        )
        viewModelScope.launch {
            _listMovies.postValue(list)
        }
    }
}