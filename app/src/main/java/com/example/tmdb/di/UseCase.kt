package diogo.com.br.di

import com.example.domain.entity.DetailMovieEntity
import com.example.domain.interector.SingleUseCase
import com.example.domain.interector.moviedetail.GetDetailMovie
import org.koin.core.qualifier.named
import org.koin.dsl.module

val mUseCase = module {
    single<SingleUseCase<DetailMovieEntity, GetDetailMovie.Params>>(named(GET_USE_CASE_DETAIL_MOVIE)) {
        GetDetailMovie(get(), get(named(MAIN_THREAD)))
    }
}