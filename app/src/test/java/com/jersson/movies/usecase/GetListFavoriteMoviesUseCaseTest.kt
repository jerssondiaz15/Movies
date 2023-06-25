package com.jersson.movies.usecase

import com.jersson.movies.domain.repository.IMovieRepository
import com.jersson.movies.domain.test.Data
import com.jersson.movies.domain.usecase.GetListFavoriteMoviesUseCase
import com.jersson.movies.presentation.ui.model.MoviesState
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetListFavoriteMoviesUseCaseTest {

    @RelaxedMockK
    private lateinit var iMovieRepository: IMovieRepository

    lateinit var getListFavoriteMoviesUseCase: GetListFavoriteMoviesUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getListFavoriteMoviesUseCase = GetListFavoriteMoviesUseCase(iMovieRepository)
    }

    @Test
    fun `when the room return data`() = runBlocking {
        //Given
        val data: List<MoviesState.Movie> = Data.listMovies
        coEvery { iMovieRepository.getListFavorite() } returns data

        //When
        val response = getListFavoriteMoviesUseCase.invoke()

        //Then
        coVerify(exactly = 1) { iMovieRepository.getListFavorite() }
        assert(response == data)
    }
}