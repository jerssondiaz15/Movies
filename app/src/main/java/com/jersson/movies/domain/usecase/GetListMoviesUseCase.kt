package com.jersson.movies.domain.usecase

import com.jersson.movies.domain.repository.IMovieRepository
import com.jersson.movies.presentation.ui.model.MoviesState
import javax.inject.Inject

class GetListMoviesUseCase @Inject constructor(
    private val iMovieRepository: IMovieRepository
) {

    suspend operator fun invoke(): List<MoviesState.Movie> {
        return listOf(
            MoviesState.Movie(
                title = "La la land",
                voteAverage = 1.0,
                isFavorite = true
            ),
            MoviesState.Movie(
                title = "La la land",
                voteAverage = 2.0,
                isFavorite = true
            ),
            MoviesState.Movie(
                title = "La la land",
                voteAverage = 3.0,
                isFavorite = true
            ),
            MoviesState.Movie(
                title = "La la land",
                voteAverage = 4.0,
                isFavorite = true
            ),
            MoviesState.Movie(
                title = "La la land",
                voteAverage = 5.0,
                isFavorite = true
            )
        )
        //return iMovieRepository.getListMovie()
    }

}