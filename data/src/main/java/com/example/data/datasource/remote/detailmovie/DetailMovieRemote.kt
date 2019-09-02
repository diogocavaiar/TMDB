package diogo.com.br.data.datasource.remote.detailmovie

import com.example.domain.entity.DetailMovieEntity
import io.reactivex.Single

interface DetailMovieRemote {

    fun getDetailMovieSingle(movieId: Int): Single<DetailMovieEntity>

}