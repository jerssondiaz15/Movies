package com.jersson.movies.domain.usecase

import com.jersson.movies.domain.repository.IMovieRepository
import com.jersson.movies.presentation.ui.model.MoviesState
import javax.inject.Inject

class GetUpdateMovieUseCase @Inject constructor(
    private val iMovieRepository: IMovieRepository,
) {
    suspend operator fun invoke(isFavorite: Boolean, id: Int){
        iMovieRepository.updateMovie(isFavorite, id)
    }
}