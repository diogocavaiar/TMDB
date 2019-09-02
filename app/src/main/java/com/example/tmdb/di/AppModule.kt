package diogo.com.br.di

import com.example.domain.executor.PostExecutionThread
import com.example.tmdb.UiThread
import com.example.tmdb.util.extensions.DateFormatter
import diogo.com.br.data.mapper.IDateFormatter
import org.koin.core.qualifier.named
import org.koin.dsl.module


val mDateFormatter = module {
    single<IDateFormatter>(named(DATE_FORMATTER)) {
        DateFormatter()
    }
}

val mPostExecutionThread = module {
    single<PostExecutionThread>(named(MAIN_THREAD)) {
        UiThread()
    }
}

const val POPULAR_MOVIE_API = "popular_movie_api"
const val DETAIL_MOVIE_API = "detail_movie_api"
const val MAPPER_POPULAR_MOVIE = "mapper_popular_movie"
const val MAPPER_DETAIL_MOVIE = "mapper_detail_movie"
const val DATE_FORMATTER = "date_formatter"
const val GET_USE_CASE_DETAIL_MOVIE = "get_use_case_popular_moview"
const val MAIN_THREAD = "man_thread"
const val POPULAR_MOVIE_DATA_SOURCE = "popular_movie_data_source"
const val POPULAR_MOVIE_DATA_SOURCE_FACTORY = "popular_movie_data_source_factory"
const val CONFIG_PAGE_LIST = "config_page_list"
const val PAGE_SIZE = 30
const val INITIAL_LOAD_SIZE_HINT = 30