package com.jersson.movies.usecase

import com.jersson.movies.data.movie.remote.MovieRemoteRepository
import com.jersson.movies.domain.repository.IMovieRepository
import com.jersson.movies.domain.test.Data.listMovies
import com.jersson.movies.domain.usecase.GetListMoviesUseCase
import com.jersson.movies.presentation.ui.model.MoviesState
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetListMoviesUseCaseTest {

    @RelaxedMockK
    private lateinit var iMovieRepository: IMovieRepository

    @RelaxedMockK
    private lateinit var repository: MovieRemoteRepository

    lateinit var getListMoviesUseCase: GetListMoviesUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getListMoviesUseCase = GetListMoviesUseCase(iMovieRepository, repository)
    }

    @Test
    fun `when the api return the movie data from api`() = runBlocking {
        //Given
        val data: List<MoviesState.Movie> = listMovies
        coEvery { repository.getListMovies() } returns data

        //When
        val response = getListMoviesUseCase.invoke()

        //Then
        coVerify(exactly = 1) { repository.getListMovies() }
        assert(response == data)
    }
}