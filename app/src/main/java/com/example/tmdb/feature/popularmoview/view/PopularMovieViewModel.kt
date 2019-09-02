package diogo.com.br.desafiomobile.feature.popularmoview.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.domain.entity.MovieEntity
import diogo.com.br.data.datasource.remote.popularmovie.PopularMovieDataSourceFactory

class PopularMovieViewModel(popularMovieDataSourceFactory: PopularMovieDataSourceFactory, config: PagedList.Config) : ViewModel() {

    private val popularMovie = LivePagedListBuilder(popularMovieDataSourceFactory, config).build()

    fun getPopularMovie(): LiveData<PagedList<MovieEntity>> {
        return popularMovie
    }
}