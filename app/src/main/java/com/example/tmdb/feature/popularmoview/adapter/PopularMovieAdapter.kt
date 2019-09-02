package diogo.com.br.desafiomobile.feature.popularmoview.adapter

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.domain.entity.MovieEntity

class PopularMovieAdapter(val callback: (idMovie: Int) -> Unit) : PagedListAdapter<MovieEntity, PopularMovieViewHolder>(PopularMovieDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMovieViewHolder {
        return PopularMovieViewHolder.create(
            parent
        )
    }

    override fun onBindViewHolder(holder: PopularMovieViewHolder, position: Int) {
        holder.bind(getItem(position)!!, callback)
    }

    companion object {
        val PopularMovieDiffCallback = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }
        }
    }
}