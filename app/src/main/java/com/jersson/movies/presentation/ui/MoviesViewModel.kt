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

    private val resource = context.resources

    private var _state = mutableStateOf(MoviesState())
    val state: State<MoviesState> = _state

    private val _listMovies = MutableLiveData<List<MoviesState.Movie>>()
    val listMovies: LiveData<List<MoviesState.Movie>> get() = _listMovies

    private val _movie = MutableLiveData<MoviesState.Movie>()
    val movie: LiveData<MoviesState.Movie> get() = _movie

    val navigateToNewActivity = MutableLiveData<Unit>()

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
            listMovies = list,
            navigate = state.value.navigate.copy(
                goToDetail = ::goToDetail
            ),
            funtionMovie = state.value.funtionMovie.copy(
                movieSelected = ::movieSelected
            )
        )
        viewModelScope.launch {
            _listMovies.postValue(_state.value.listMovies)
            _movie.postValue(_state.value.movieSelected)
        }
    }

    private fun goToDetail(){
        navigateToNewActivity.value = Unit
    }
    private fun movieSelected(movie: MoviesState.Movie){
        _state.value = state.value.copy(
            movieSelected = movie
        )
    }
}