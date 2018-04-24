package io.github.mcasper3.gitgud.repositories

import io.reactivex.Observable
import retrofit2.http.GET

interface RepositoryService {

    @GET("user/repos")
    fun getRepositories(): Observable<RepositoryResponse>
}
