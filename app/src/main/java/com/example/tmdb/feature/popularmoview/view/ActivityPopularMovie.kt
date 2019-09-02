package diogo.com.br.desafiomobile.feature.popularmoview.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tmdb.R
import diogo.com.br.desafiomobile.feature.detailmovie.view.ActivityDetailMovie
import diogo.com.br.desafiomobile.feature.popularmoview.adapter.PopularMovieAdapter
import kotlinx.android.synthetic.main.activity_popular_movie.*
import org.koin.android.viewmodel.ext.android.viewModel


class ActivityPopularMovie : AppCompatActivity() {

    private val mPopularViewModel: PopularMovieViewModel by viewModel()
    private val mAdapter = PopularMovieAdapter { movieId ->
        ActivityDetailMovie.newInstance(this, movieId)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popular_movie)

        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = mAdapter

        mPopularViewModel.getPopularMovie().observe(this, Observer {
            mAdapter.submitList(it)
        })
    }
}
