package diogo.com.br.data.mapper

import com.example.domain.entity.MovieEntity
import com.example.domain.entity.PopularMovieEntity
import diogo.com.br.data.entity.PopularMovieResponse
import diogo.com.br.data.entity.ResultResponse


class PopularMovieMapper(private val dateFormatter: IDateFormatter) : Mapper<PopularMovieResponse, PopularMovieEntity> {
    override fun map(from: PopularMovieResponse): PopularMovieEntity {
        return PopularMovieEntity(from.page,
            from.total_pages,
            mapListResultResponseToResultEntity(from.results)
            )
    }

    private fun mapListResultResponseToResultEntity(results: MutableList<ResultResponse>) = results.map { mapResultToEntity(it) }.toMutableList()

    private fun mapResultToEntity(result: ResultResponse) : MovieEntity {
        return MovieEntity(result.id,
            result.title,
            "http://image.tmdb.org/t/p/w185/" + result.poster_path,
            result.vote_average,
            dateFormatter.format(result.release_date),
            result.genre_ids)
    }
}