package com.jersson.movies.data.di

import android.content.Context
import androidx.room.Room
import com.jersson.movies.data.movie.local.MovieDataBase
import com.jersson.movies.data.movie.local.MovieRepository
import com.jersson.movies.data.movie.local.datasource.MovieDatabaseDataSource
import com.jersson.movies.data.movie.remote.network.MovieApiClient
import com.jersson.movies.domain.repository.IMovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/movie/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideMovieApiClient(retrofit: Retrofit): MovieApiClient{
        return retrofit.create(MovieApiClient::class.java)
    }

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