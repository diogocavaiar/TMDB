package diogo.com.br.desafiomobile.feature.detailmovie.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.domain.entity.CreditsEntity
import com.example.domain.entity.DetailMovieEntity
import com.example.domain.entity.GenresEntity
import com.example.tmdb.R
import com.example.tmdb.util.extensions.collapse
import com.example.tmdb.util.extensions.show
import diogo.com.br.desafiomobile.feature.detailmovie.adapter.DetailMovieAdapter
import kotlinx.android.synthetic.main.activity_detail_movie.*
import kotlinx.android.synthetic.main.activity_error_connection.*
import kotlinx.android.synthetic.main.content_main_detail.*
import org.koin.android.viewmodel.ext.android.viewModel

class ActivityDetailMovie : AppCompatActivity() {

    private val mViewModel: DetailMovieViewModel by viewModel()
    private val mAdapter = DetailMovieAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)
        initComponents()
        initObserver()
    }

    override fun onStart() {
        super.onStart()
        mViewModel.loadDetailMovie(getMovieId())
    }

    private fun initComponents() {
        recyclerViewCast.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewCast.adapter = mAdapter
    }

    private fun initObserver() {
        mViewModel.getDetailMovie().observe(this, Observer {
            chackState(it)
        })
    }

    private fun getMovieId(): Int {
        return intent.extras.get(MOVIE_ID) as Int
    }

    private fun chackState(viewState: DetailMovieViewState) {
        when(viewState) {
            is Loading -> {
                progressBar.show()
            }
            is Content -> {
                updateUi(viewState.content)
            }
            is Error -> {
                showLayoutError(viewState.error)
            }
        }
    }

    private fun updateUi(it: DetailMovieEntity?) {
        progressBar.collapse()
        enableComponents()
        setImagePoster(it?.posterPath)
        setTvTitle(it?.originalTitle)
        setYear(it?.releaseDate)
        setRuntime(it?.runtime?.plus("m")?:"")
        setListGenres(it?.genres)
        setOverview(it?.overview)
        setListAdapter(it?.credits)
    }

    private fun showLayoutError(error: String) {
        progressBar.collapse()
        contentError.show()
        messageError.text = error
        btnRetry.setOnClickListener{
            collapseLayoutError()
            mViewModel.loadDetailMovie(getMovieId())
        }
    }

    private fun collapseLayoutError() {
        contentError.collapse()
    }

    private fun enableComponents() {
        appbar.show()
        contentMainDetail.show()
    }

    private fun setListGenres(genres: MutableList<GenresEntity>?) {
        val genresBuilder = StringBuilder()
        genres?.forEach{ genre ->
            if(genresBuilder.isNotEmpty())
                genresBuilder.append(", ")
            genresBuilder.append(genre.name)
        }
        tvGenres.text = genresBuilder.toString()
    }

    private fun setListAdapter(credits: MutableList<CreditsEntity>?) {
        mAdapter.setListCast(credits)
    }

    private fun setOverview(overview: String?) {
        tvOverview.text = overview
    }

    private fun setRuntime(runtime: String) {
        tvRuntime.text = runtime
    }

    private fun setYear(releaseDate: String?) {
        tvYear.text = releaseDate
    }

    private fun setTvTitle(originalTitle: String?) {
        tvTitle.text = originalTitle
    }

    private fun setImagePoster(posterPath: String?) {
        Glide.with(this)
            .load(posterPath)
            .transition(DrawableTransitionOptions.withCrossFade(1000))
            .into(backdropPath)
    }

    companion object {
        const val MOVIE_ID = "movie_id"
        fun newInstance(context: Context, movieId: Int) {
            context.startActivity(Intent(context, ActivityDetailMovie::class.java).apply {
                putExtra(MOVIE_ID, movieId)
            })
        }
    }
}