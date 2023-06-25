package com.jersson.movies.presentation.ui

import android.content.Context
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jersson.movies.domain.usecase.GetListFavoriteMoviesUseCase
import com.jersson.movies.domain.usecase.GetListMoviesUseCase
import com.jersson.movies.domain.usecase.GetUpdateMovieUseCase
import com.jersson.movies.presentation.ui.model.MoviesState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    @ApplicationContext context: Context,
    private val getListMoviesUseCase: GetListMoviesUseCase,
    private val getListFavoriteMoviesUseCase: GetListFavoriteMoviesUseCase,
    private val getUpdateMovieUseCase: GetUpdateMovieUseCase
) : ViewModel(){

    private val resource = context.resources

    private var _state = mutableStateOf(MoviesState())
    val state: State<MoviesState> = _state

    init {
        _state.value = state.value.copy(
            navigate = state.value.navigate.copy(
                //goToDetail = ::goToDetail
            ),
            funtionMovie = state.value.funtionMovie.copy(
                movieSelected = ::movieSelected,
                onFavorite = ::onFavorite
            )
        )
        getList()
        getFavorite()
    }
    private fun getList(){
        viewModelScope.launch {
            val result = getListMoviesUseCase.invoke()
            _state.value = state.value.copy(
                listMovies = result.sortedBy { it.id },
            )
            Log.i("getListMoviesUseCase: ", result.toString())
        }
    }

    private fun getFavorite(){
        viewModelScope.launch {
            val result = getListFavoriteMoviesUseCase.invoke()
            _state.value = state.value.copy(
                listFavorite = result.sortedBy { it.id },
            )
            Log.i("getListFavoriteMoviesUseCase: ", result.toString())
        }
    }

    private fun movieSelected(movie: MoviesState.Movie){
        _state.value = state.value.copy(
            movieSelected = movie
        )
    }

    private fun onFavorite(movie: MoviesState.Movie){
        viewModelScope.launch {
            run {
                getUpdateMovieUseCase(
                    isFavorite = !movie.isFavorite,
                    id = movie.id
                )
            }
            getList()
            getFavorite()
        }
    }
}