package io.github.mcasper3.gitgud.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import io.github.mcasper3.gitgud.R
import io.github.mcasper3.gitgud.base.GitGudActivity
import io.github.mcasper3.gitgud.base.list.RecyclerViewConfiguration
import io.github.mcasper3.gitgud.main.repositories.RepositoryFragment
import io.github.mcasper3.gitgud.main.repositories.RepositoryRouter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : GitGudActivity() {

    @Inject internal lateinit var repositoryRouter: RepositoryRouter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO backstack listener to update the toolbar and animate fab
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.content, RepositoryFragment().apply {
                    this.configuration = RecyclerViewConfiguration(LinearLayoutManager(context))
                })
                .commit()
        }

        bottomBar.setOnNavigationItemSelectedListener { true }
    }
}
