package com.example.tmdb

import android.app.Application
import diogo.com.br.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        loadKoin()
    }

    private fun loadKoin() {
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(listOf(mNetworkModules, mDateFormatter, mMapper, mRepositoryPopularMovie, mRepositoryDetailMovie, mPostExecutionThread, mUseCase, mPagedListConfig, mViewModel))
        }
    }
}