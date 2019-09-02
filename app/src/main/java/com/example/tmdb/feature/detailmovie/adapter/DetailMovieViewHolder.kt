package diogo.com.br.desafiomobile.feature.detailmovie.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.entity.CreditsEntity
import com.example.tmdb.R
import kotlinx.android.synthetic.main.item_detail_movie.view.*

class DetailMovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(creditsEntity: CreditsEntity) {
        Glide.with(itemView.imageViewActor)
            .load(creditsEntity.profile_path)
            .placeholder(R.drawable.placeholder_image)
            .error(R.drawable.not_photo)
            .into(itemView.imageViewActor)
        itemView.tvName.text = creditsEntity.name
    }


    companion object {
        fun create(parent: ViewGroup): DetailMovieViewHolder {
            return DetailMovieViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_detail_movie,
                    parent,
                    false
                )
            )
        }
    }
}