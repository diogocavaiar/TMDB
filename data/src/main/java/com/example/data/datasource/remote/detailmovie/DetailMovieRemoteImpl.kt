package diogo.com.br.data.datasource.remote.detailmovie

import com.example.domain.entity.DetailMovieEntity
import diogo.com.br.data.entity.CreditsResponse
import diogo.com.br.data.entity.DetailMovieResponse
import diogo.com.br.data.mapper.DetailMovieMapper
import io.reactivex.Single
import io.reactivex.Single.zip
import io.reactivex.functions.BiFunction

class DetailMovieRemoteImpl(
    private val detailMovieApi: DetailMovieApi,
    private val mapper: DetailMovieMapper
) : DetailMovieRemote {

    override fun getDetailMovieSingle(movieId: Int): Single<DetailMovieEntity> {
        return zip(
            detailMovieApi.getDetailMoviee(movieId),
            detailMovieApi.getMovieCreditss(movieId),
            BiFunction<DetailMovieResponse, CreditsResponse, DetailMovieEntity> {
                detailMovie, creditsMovie ->
                createDetailMovieEntity(detailMovie, creditsMovie)!!
            })
    }

    private fun createDetailMovieEntity(detailMovie: DetailMovieResponse, creditsMovie: CreditsResponse): DetailMovieEntity? {
        detailMovie.creditsResponse = creditsMovie
        return mapper.map(detailMovie)
    }
}