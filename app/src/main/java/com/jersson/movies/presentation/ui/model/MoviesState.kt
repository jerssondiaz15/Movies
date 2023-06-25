package com.jersson.movies.presentation.ui.model

import android.os.Parcel
import android.os.Parcelable

data class MoviesState(
    val listMovies: List<Movie> = listOf(),
    val listFavorite: List<Movie> = listOf(),
    val movieSelected: Movie = Movie(),
    val funtionMovie: FuntionMovie = FuntionMovie()
) {
    data class Movie(
        val id: Int = 1,
        val backdropPath: String? = "",
        val originalLanguage: String? = "",
        val coin: String? = "",
        val synopsis: String? = "",
        val posterPath: String? = "",
        val releaseDate: String? = "",
        val title: String? = "",
        val voteAverage: Double? = 0.0,
        var isFavorite: Boolean = false
    ): Parcelable {
        constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readValue(Double::class.java.classLoader) as? Double,
            parcel.readByte() != 0.toByte()
        )

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeInt(id)
            parcel.writeString(backdropPath)
            parcel.writeString(originalLanguage)
            parcel.writeString(coin)
            parcel.writeString(synopsis)
            parcel.writeString(posterPath)
            parcel.writeString(releaseDate)
            parcel.writeString(title)
            parcel.writeValue(voteAverage)
            parcel.writeByte(if (isFavorite) 1 else 0)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<Movie> {
            override fun createFromParcel(parcel: Parcel): Movie {
                return Movie(parcel)
            }

            override fun newArray(size: Int): Array<Movie?> {
                return arrayOfNulls(size)
            }
        }
    }

    data class FuntionMovie(
        val onFavorite: ((Movie) -> Unit)? = null
    )
}