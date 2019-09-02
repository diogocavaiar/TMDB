package diogo.com.br.data.mapper

import com.example.domain.entity.CreditsEntity
import com.example.domain.entity.DetailMovieEntity
import com.example.domain.entity.GenresEntity
import diogo.com.br.data.entity.CastResponse
import diogo.com.br.data.entity.DetailMovieResponse
import diogo.com.br.data.entity.GenresResponse

class DetailMovieMapper(private val dateFormatter: IDateFormatter) : Mapper<DetailMovieResponse, DetailMovieEntity> {
    override fun map(from: DetailMovieResponse): DetailMovieEntity {
        return DetailMovieEntity(from.id,"http://image.tmdb.org/t/p/w500/" + from.backdrop_path,
            from.original_title, mapListGenresResponseToGenresEntity(from.genres), dateFormatter.format(from.release_date!!, "yyyy"),
            from.overview, from.runtime?:"0", mapListCreditsResponseToCreditsEntity(from.creditsResponse.cast))
    }

    private fun mapListGenresResponseToGenresEntity(results: MutableList<GenresResponse>) = results.map { mapGenreToEntity(it) }.toMutableList()

    private fun mapGenreToEntity(genre: GenresResponse) : GenresEntity {
        return GenresEntity(genre.name)
    }

    private fun mapListCreditsResponseToCreditsEntity(results: MutableList<CastResponse>) = results.map { mapCreditsToEntity(it) }.toMutableList()

    private fun mapCreditsToEntity(cast: CastResponse?) : CreditsEntity {
        return CreditsEntity(cast?.name, "http://image.tmdb.org/t/p/w185/" + cast?.profile_path)
    }
}