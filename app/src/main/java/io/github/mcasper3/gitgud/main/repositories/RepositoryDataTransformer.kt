package io.github.mcasper3.gitgud.main.repositories

import javax.inject.Inject

class RepositoryDataTransformer @Inject constructor() {

    fun convertRepositories(repositories: List<ApiRepository>) = repositories.map { Repository(it.fullName, it.description, null) }
        .map { RepositoryViewHolderFactory(it) }
}
