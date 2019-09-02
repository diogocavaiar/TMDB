package diogo.com.br.desafiomobile.feature.detailmovie.view

import com.example.domain.entity.DetailMovieEntity

sealed class DetailMovieViewState

object Loading : DetailMovieViewState()
data class Error(val error: String) : DetailMovieViewState()
data class Content(val content: DetailMovieEntity) : DetailMovieViewState()