package com.example.data.repository

import com.example.domain.entity.DetailMovieEntity
import com.example.domain.repository.DetailMovieRepository
import diogo.com.br.data.datasource.remote.detailmovie.DetailMovieRemote
import io.reactivex.Single

class DetailMovieRepositoryImpl(private val repositoryRemote: DetailMovieRemote) :
    DetailMovieRepository {

    override fun getDetailMovie(movieId: Int): Single<DetailMovieEntity> {
        return repositoryRemote.getDetailMovieSingle(movieId)
    }
}