package diogo.com.br.desafiomobile.feature.detailmovie.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entity.CreditsEntity

class DetailMovieAdapter : RecyclerView.Adapter<DetailMovieViewHolder>() {

    private val mListCast: MutableList<CreditsEntity> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailMovieViewHolder {
        return DetailMovieViewHolder.create(parent)
    }

    override fun getItemCount(): Int {
        return mListCast.size
    }

    override fun onBindViewHolder(holder: DetailMovieViewHolder, position: Int) {
        holder.bind(mListCast[position])
    }

    fun setListCast(listCast: MutableList<CreditsEntity>?) {
        if(listCast != null) {
            mListCast.addAll(listCast)
            notifyDataSetChanged()
        }
    }
}