package diogo.com.br.di

import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import com.example.data.repository.DetailMovieRepositoryImpl
import com.example.domain.entity.MovieEntity
import com.example.domain.repository.DetailMovieRepository
import diogo.com.br.data.datasource.remote.detailmovie.DetailMovieRemote
import diogo.com.br.data.datasource.remote.detailmovie.DetailMovieRemoteImpl
import diogo.com.br.data.datasource.remote.popularmovie.PopularMovieDataSource
import diogo.com.br.data.datasource.remote.popularmovie.PopularMovieDataSourceFactory
import org.koin.core.qualifier.named
import org.koin.dsl.module

val mRepositoryPopularMovie = module {
    single<PageKeyedDataSource<Int, MovieEntity>>(named(POPULAR_MOVIE_DATA_SOURCE)) {
        PopularMovieDataSource(
            get(named(POPULAR_MOVIE_API)),
            get(named(MAPPER_POPULAR_MOVIE))
        )
    }

    single<DataSource.Factory<Int, MovieEntity>>(named(POPULAR_MOVIE_DATA_SOURCE_FACTORY)) {
        PopularMovieDataSourceFactory(
            get(named(POPULAR_MOVIE_DATA_SOURCE))
        )
    }
}

val mRepositoryDetailMovie = module {
    single<DetailMovieRemote> {
        DetailMovieRemoteImpl(get(named(DETAIL_MOVIE_API)), get(named(MAPPER_DETAIL_MOVIE)))
    }
    single<DetailMovieRepository> {
        DetailMovieRepositoryImpl(get())
    }
}

val mPagedListConfig = module {
    single(named(CONFIG_PAGE_LIST)) {
        PagedList.Config.Builder()
            .setPageSize(PAGE_SIZE)
            .setInitialLoadSizeHint(INITIAL_LOAD_SIZE_HINT)
            .setEnablePlaceholders(false)
            .build() }
}