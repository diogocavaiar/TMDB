package diogo.com.br.di

import com.example.domain.entity.DetailMovieEntity
import com.example.domain.entity.PopularMovieEntity
import diogo.com.br.data.entity.DetailMovieResponse
import diogo.com.br.data.entity.PopularMovieResponse
import diogo.com.br.data.mapper.DetailMovieMapper
import diogo.com.br.data.mapper.Mapper
import diogo.com.br.data.mapper.PopularMovieMapper
import org.koin.core.qualifier.named
import org.koin.dsl.module

val mMapper = module {
    single<Mapper<PopularMovieResponse, PopularMovieEntity>>(named(MAPPER_POPULAR_MOVIE)) { PopularMovieMapper(get(
        named(DATE_FORMATTER)
    )) }
    single<Mapper<DetailMovieResponse, DetailMovieEntity>>(named(MAPPER_DETAIL_MOVIE)) { DetailMovieMapper(get(
        named(DATE_FORMATTER)
    )) }
}