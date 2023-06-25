package com.jersson.movies.data.movie.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
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

    @Query("Update movie_table SET isFavorite = :isFavorite  WHERE id = :id")
    suspend fun updateMovie(isFavorite: Boolean, id: Int)

}