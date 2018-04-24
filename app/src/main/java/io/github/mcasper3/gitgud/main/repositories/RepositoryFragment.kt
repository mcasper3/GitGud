package io.github.mcasper3.gitgud.main.repositories

import android.os.Bundle
import android.view.View
import io.github.mcasper3.gitgud.base.list.ListFragment
import javax.inject.Inject

class RepositoryFragment : ListFragment() {

    @Inject internal lateinit var presenter: RepositoryPresenter

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getRepositories()
            .subscribe {
                adapter.viewHolderFactories = it
            }
    }
}
