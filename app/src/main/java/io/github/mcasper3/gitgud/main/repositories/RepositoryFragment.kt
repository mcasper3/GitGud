package io.github.mcasper3.gitgud.repositories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.mcasper3.gitgud.R
import io.github.mcasper3.gitgud.base.BaseFragment
import javax.inject.Inject

class RepositoryFragment : BaseFragment() {

    @Inject internal lateinit var presenter: RepositoryPresenter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_list, container)
    }
}
