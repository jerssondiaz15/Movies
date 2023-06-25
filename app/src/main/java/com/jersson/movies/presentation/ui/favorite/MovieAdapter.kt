package com.jersson.movies.presentation.ui.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.jersson.movies.databinding.ItemMovieFavoriteBinding
import com.jersson.movies.presentation.ui.model.MoviesState

class MovieAdapter(
    private val listOnItemClick: OnItemClick
): ListAdapter<MoviesState.Movie, MovieAdapter.ViewHolder>(PhotoDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemMovieFavoriteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemMovieFavoriteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MoviesState.Movie) {
            binding.apply {
                ivImImage.load(URL + item.posterPath)
                tvImTittle.text = item.title
                rbImVoteAverage.rating = item.voteAverage!!.toFloat()
                root.setOnClickListener {
                    listOnItemClick.onClick(item)
                }
            }
        }
    }
}

interface OnItemClick {
    fun onClick(item: MoviesState.Movie)
}

private class PhotoDiffCallback : DiffUtil.ItemCallback<MoviesState.Movie>() {
    override fun areItemsTheSame(oldItem: MoviesState.Movie, newItem: MoviesState.Movie): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: MoviesState.Movie, newItem: MoviesState.Movie): Boolean =
        oldItem.id == newItem.id
}

const val URL = "https://image.tmdb.org/t/p/w500/"