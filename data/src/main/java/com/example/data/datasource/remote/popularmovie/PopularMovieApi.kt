package diogo.com.br.data.datasource.remote.popularmovie

import diogo.com.br.data.entity.PopularMovieResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface PopularMovieApi {

    @GET("movie/popular")
    fun getPopularMovie(@Query("page") page: Int = 1): Observable<PopularMovieResponse>

}