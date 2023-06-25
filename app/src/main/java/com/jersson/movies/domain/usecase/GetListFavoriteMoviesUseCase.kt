package com.jersson.movies.domain.usecase

import com.jersson.movies.domain.repository.IMovieRepository
import com.jersson.movies.presentation.ui.model.MoviesState
import javax.inject.Inject

class GetListFavoriteMoviesUseCase  @Inject constructor(
    private val iMovieRepository: IMovieRepository
) {
    suspend operator fun invoke(): List<MoviesState.Movie> {
        return iMovieRepository.getListFavorite()
    }
}