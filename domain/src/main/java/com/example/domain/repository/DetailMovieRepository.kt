package com.example.domain.repository

import com.example.domain.entity.DetailMovieEntity
import io.reactivex.Single

interface DetailMovieRepository {

    fun getDetailMovie(movieId: Int): Single<DetailMovieEntity>

}