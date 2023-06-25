package com.jersson.movies.domain.usecase

import com.jersson.movies.data.movie.remote.MovieRemoteRepository
import com.jersson.movies.domain.repository.IMovieRepository
import com.jersson.movies.presentation.ui.model.MoviesState
import javax.inject.Inject

class GetListMoviesUseCase @Inject constructor(
    private val iMovieRepository: IMovieRepository,
    private val repository: MovieRemoteRepository
) {

    suspend operator fun invoke(): List<MoviesState.Movie> {
        val movie = repository.getListMovies()
        val roomList = iMovieRepository.getListMovie()
        return if (roomList.isNotEmpty()){
            iMovieRepository.getListMovie()
        } else{
            if (movie!!.isNotEmpty()){
                movie.map {
                    iMovieRepository.insertMovies(it)
                }
                movie
            } else{
                iMovieRepository.getListMovie()
            }
        }
    }
}