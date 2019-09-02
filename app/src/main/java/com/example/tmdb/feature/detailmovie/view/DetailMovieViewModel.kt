package diogo.com.br.desafiomobile.feature.detailmovie.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.interector.moviedetail.GetDetailMovie
import com.example.tmdb.GenericException

class DetailMovieViewModel(private val getDetailMovie: GetDetailMovie) : ViewModel() {

    private val detailMovie: MutableLiveData<DetailMovieViewState> = MutableLiveData()

    fun loadDetailMovie(movieId: Int) {
        getDetailMovie.execute(GetDetailMovie.Params.forDetailMovie(movieId), {
            detailMovie.postValue(Loading)
        },{
            detailMovie.postValue(Content(it))
        }, {
            detailMovie.postValue(Error(GenericException.getErrorMessage(it)))
        })
    }

    fun getDetailMovie(): MutableLiveData<DetailMovieViewState> {
        return detailMovie
    }

}