package diogo.com.br.data.datasource.remote.detailmovie

import diogo.com.br.data.entity.CreditsResponse
import diogo.com.br.data.entity.DetailMovieResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailMovieApi {

    @GET("movie/{movie_id}")
    fun getDetailMoviee(@Path("movie_id") movieId: Int): Single<DetailMovieResponse>

    @GET("movie/{movie_id}/credits")
    fun getMovieCreditss(@Path("movie_id") movieId: Int): Single<CreditsResponse>

}