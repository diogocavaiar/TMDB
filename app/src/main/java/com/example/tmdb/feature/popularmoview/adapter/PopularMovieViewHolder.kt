package diogo.com.br.desafiomobile.feature.popularmoview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.entity.MovieEntity
import com.example.tmdb.R
import kotlinx.android.synthetic.main.item_popular_movie.view.*

class PopularMovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(movie: MovieEntity, callback: (idMovie: Int) -> Unit) {
        itemView.content.setOnClickListener{callback.invoke(movie.id)}
        itemView.title.text = movie.title
        itemView.dataLancamento.text = movie.releaseDate
        itemView.nota.text = movie.voteAverage.toString()
        Glide.with(itemView)
            .load(movie.posterPath)
            .placeholder(R.drawable.placeholder_image)
            .error(R.drawable.not_photo)
            .into(itemView.imageView)
    }

    companion object {
        fun create(parent: ViewGroup): PopularMovieViewHolder {
            return PopularMovieViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_popular_movie,
                    parent,
                    false
                )
            )
        }
    }
}