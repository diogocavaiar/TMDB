package com.example.domain.interector.moviedetail

import com.example.domain.entity.DetailMovieEntity
import com.example.domain.executor.PostExecutionThread
import com.example.domain.interector.SingleUseCase
import com.example.domain.repository.DetailMovieRepository
import io.reactivex.Single

class GetDetailMovie(
    private val repository: DetailMovieRepository,
    postExecutionThread: PostExecutionThread
) : SingleUseCase<DetailMovieEntity, GetDetailMovie.Params>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Params?): Single<DetailMovieEntity> {
        if(params == null) throw IllegalArgumentException("Params can't be null!")

        return repository.getDetailMovie(params.idMovie)
    }


    data class Params(val idMovie: Int) {
        companion object {
            fun forDetailMovie(idMovie: Int): Params {
                return Params(idMovie)
            }
        }
    }
}