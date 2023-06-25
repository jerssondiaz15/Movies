package com.jersson.movies.presentation.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.jersson.movies.databinding.FragmentMovieFavoriteBinding
import com.jersson.movies.presentation.ui.MoviesViewModel
import com.jersson.movies.presentation.ui.model.MoviesState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFragment: Fragment() {

    private var _binding: FragmentMovieFavoriteBinding? = null
    private val binding: FragmentMovieFavoriteBinding get() = _binding!!

    private val viewModel: MoviesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieFavoriteBinding.inflate(inflater, container, false)
        initView()
        initListener()
        initObservers()
        return binding.root
    }

    private fun initListener() {
    }

    private fun initView() {
        binding.rvFpCoinList.layoutManager = LinearLayoutManager(context)
    }

    private fun initObservers() {
        binding.apply {
            viewModel.listMovies.observe(viewLifecycleOwner){ list ->
                val movieAdapter = MovieAdapter(object: OnItemClick {
                    override fun onClick(item: MoviesState.Movie) {
                        //viewModel.setMovie(item)
                        //findNavController().navigate(R.id.action_movie_to_movie_detail)
                    }
                })
                movieAdapter.submitList(list)
                rvFpCoinList.adapter = movieAdapter
            }
        }
    }

}