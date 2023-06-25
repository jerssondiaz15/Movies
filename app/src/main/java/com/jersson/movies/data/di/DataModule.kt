package com.jersson.movies.data.di

import android.content.Context
import androidx.room.Room
import com.jersson.movies.data.movie.local.MovieDataBase
import com.jersson.movies.data.movie.local.MovieRepository
import com.jersson.movies.data.movie.local.datasource.MovieDatabaseDataSource
import com.jersson.movies.domain.repository.IMovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    private const val MOVIE_DATABASE_NAME = "movie_database"

    @Provides
    @Singleton
    fun provideCoinDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, MovieDataBase::class.java, MOVIE_DATABASE_NAME)
            .build()

    @Provides
    @Singleton
    fun provideMovieDao(db: MovieDataBase) = db.movieDao()


    @Provides
    fun provideMovieRepository(
        movieDatabaseDataSource: MovieDatabaseDataSource
    ): IMovieRepository {
        return MovieRepository(
            movieDatabaseDataSource = movieDatabaseDataSource
        )
    }

    @Provides
    fun provideMovieDatabaseDataSource(
        movieDataBase: MovieDataBase
    ): MovieDatabaseDataSource {
        return MovieDatabaseDataSource(
            movieDataBase = movieDataBase
        )
    }
}