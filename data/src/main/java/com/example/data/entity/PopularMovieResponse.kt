package diogo.com.br.data.entity

import java.util.*

data class PopularMovieResponse(val page: Int, val total_pages: Int, val results: MutableList<ResultResponse>)

data class ResultResponse(val id: Int,
                          val title: String,
                          val poster_path: String,
                          val vote_average: Double,
                          val release_date: Date,
                          val genre_ids: MutableList<Int>
)