package com.example.domain.entity

data class PopularMovieEntity(val page: Int, val totalPages: Int, val movies: MutableList<MovieEntity>)

data class MovieEntity(val id: Int,
                       val title: String,
                       val posterPath: String,
                       val voteAverage: Double,
                       val releaseDate: String,
                       val genreIds: MutableList<Int>)