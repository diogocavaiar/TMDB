package diogo.com.br.data.datasource.remote.popularmovie

import androidx.paging.DataSource
import diogo.com.br.domain.entity.MovieEntity

class PopularMovieDataSourceFactory(private val popularMovieDataSource: PopularMovieDataSource) : DataSource.Factory<Int, MovieEntity>() {

    override fun create(): DataSource<Int, MovieEntity> {
        return popularMovieDataSource
    }
}