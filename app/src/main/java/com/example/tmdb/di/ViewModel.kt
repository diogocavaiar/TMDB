package diogo.com.br.di

import diogo.com.br.desafiomobile.feature.detailmovie.view.DetailMovieViewModel
import diogo.com.br.desafiomobile.feature.popularmoview.view.PopularMovieViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val mViewModel = module {
    viewModel {
        PopularMovieViewModel(
            get(named(POPULAR_MOVIE_DATA_SOURCE_FACTORY)),
            get(named(CONFIG_PAGE_LIST))
        )
    }

    viewModel { DetailMovieViewModel(get(named(GET_USE_CASE_DETAIL_MOVIE))) }
}