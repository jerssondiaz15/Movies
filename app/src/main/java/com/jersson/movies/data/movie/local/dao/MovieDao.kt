package com.jersson.movies.data.movie.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jersson.movies.data.movie.local.model.DbMovie

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie_table")
    suspend fun getListDbMovie(): List<DbMovie>

    @Query("DELETE FROM movie_table")
    suspend fun deleteAllMovies()

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMovies(dbMovie: DbMovie)

    @Query("SELECT * FROM movie_table WHERE isFavorite")
    suspend fun getListFavorite(): List<DbMovie>
}