package io.github.mcasper3.gitgud.main.repositories

import android.view.ViewGroup
import io.github.mcasper3.gitgud.R
import io.github.mcasper3.gitgud.base.list.BaseViewHolder
import io.github.mcasper3.gitgud.base.list.ViewHolderFactory
import io.github.mcasper3.gitgud.util.extensions.inflate

class RepositoryViewHolderFactory(item: Repository) : ViewHolderFactory<Repository>(item) {
    override fun createViewHolder(parent: ViewGroup): BaseViewHolder<Repository> {
        return RepositoryViewHolder(parent.inflate(R.layout.li_repository))
    }
}
