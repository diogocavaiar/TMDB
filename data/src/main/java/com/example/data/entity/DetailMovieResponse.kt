package diogo.com.br.data.entity

import java.util.*

data class DetailMovieResponse(val id: Int, val backdrop_path: String, val original_title: String,
                               val genres: MutableList<GenresResponse>, val release_date: Date?,
                               val overview: String, val runtime: String? = "0", var creditsResponse: CreditsResponse)

data class GenresResponse(val name: String)

data class CreditsResponse(val cast: MutableList<CastResponse>)

data class CastResponse(val name: String, val profile_path: String)

