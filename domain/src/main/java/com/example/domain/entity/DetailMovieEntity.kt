package com.example.domain.entity

data class DetailMovieEntity(val id: Int, val posterPath: String, val originalTitle: String,
                             val genres: MutableList<GenresEntity>, val releaseDate: String,
                             val overview: String, val runtime: String, val credits: MutableList<CreditsEntity>)

data class GenresEntity(val name: String)

data class CreditsEntity(val name: String?, val profile_path: String?)