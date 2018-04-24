package io.github.mcasper3.gitgud.main.repositories

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RepositoryPresenter @Inject constructor(
    private val service: RepositoryService,
    private val dataTransformer: RepositoryDataTransformer
) {

    fun getRepositories() = service.getRepositories()
        .map { dataTransformer.convertRepositories(it) }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}
