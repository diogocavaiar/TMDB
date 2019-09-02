package com.example.domain.interector

import com.example.domain.executor.PostExecutionThread
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

abstract class SingleUseCase<T, in Params>(
    private val postExecutionThread: PostExecutionThread
) {

    private val disposables = CompositeDisposable()

    abstract fun buildUseCaseObservable(params: Params? = null): Single<T>

    open fun execute(params: Params? = null,
                     doOnSubscribe: () -> Unit,
                     onSuccess: (T) -> Unit,
                     onError: (Throwable) -> Unit) {
        addDisposable(this.buildUseCaseObservable(params)
            .subscribeOn(Schedulers.io())
            .observeOn(postExecutionThread.scheduler)
            .doOnSubscribe{
                doOnSubscribe.invoke()
            }
            .subscribe ( {
                onSuccess.invoke(it)
            }, {
                onError.invoke(it)
            } ))
    }

    fun dispose() {
        disposables.dispose()
    }

    private fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }
}