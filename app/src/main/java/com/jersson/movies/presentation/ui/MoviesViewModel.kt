package com.jersson.movies.presentation.ui

import android.content.Context
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jersson.movies.domain.usecase.GetListMoviesUseCase
import com.jersson.movies.presentation.ui.model.MoviesState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    @ApplicationContext context: Context,
    private val getListMoviesUseCase: GetListMoviesUseCase
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
                movieSelected = ::movieSelected
            )
        )
        getList()
    }
    private fun getList(){
        viewModelScope.launch {
            val result = getListMoviesUseCase.invoke()

            _state.value = state.value.copy(
                listMovies = result,
            )
            Log.i("result: ", result.toString())
        }
    }

    private fun movieSelected(movie: MoviesState.Movie){
        _state.value = state.value.copy(
            movieSelected = movie
        )
    }
}