package diogo.com.br.data.datasource.remote.popularmovie

import androidx.paging.PageKeyedDataSource
import com.example.domain.entity.MovieEntity
import diogo.com.br.data.mapper.PopularMovieMapper
import io.reactivex.disposables.CompositeDisposable

class PopularMovieDataSource(private val serverApi: PopularMovieApi,
                             private val mapper: PopularMovieMapper
): PageKeyedDataSource<Int, MovieEntity>() {

    private val compositeDisposable = CompositeDisposable()

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, MovieEntity>) {
        compositeDisposable.add(serverApi.getPopularMovie()
            .map { mapper.map(it) }
            .subscribe {
                callback.onResult(it.movies, null, 2)
            })

        compositeDisposable.dispose()
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, MovieEntity>) {
        compositeDisposable.add(serverApi.getPopularMovie(params.key)
            .map { mapper.map(it) }
            .subscribe {
                if((params.key + 1) > it.totalPages) {
                    callback.onResult(it.movies, null)
                } else {
                    callback.onResult(it.movies, params.key + 1)
                }
            })

        compositeDisposable.dispose();
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, MovieEntity>) {}

}