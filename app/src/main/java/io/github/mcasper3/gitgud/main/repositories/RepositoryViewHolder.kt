package io.github.mcasper3.gitgud.main.repositories

import android.view.View
import android.widget.TextView
import io.github.mcasper3.gitgud.R
import io.github.mcasper3.gitgud.base.list.BaseViewHolder
import io.github.mcasper3.gitgud.util.extensions.hideIf

class RepositoryViewHolder(item: View) : BaseViewHolder<Repository>(item) {

    private val repositoryTitle: TextView by lazy { itemView.findViewById<TextView>(R.id.repositoryTitle) }
    private val repositoryDescription: TextView by lazy { itemView.findViewById<TextView>(R.id.repositoryDescription) }

    override fun bind(item: Repository) {
        repositoryTitle.text = item.title
        repositoryDescription.text = item.description
        repositoryDescription.hideIf(item.description.isNullOrEmpty())
    }
}
