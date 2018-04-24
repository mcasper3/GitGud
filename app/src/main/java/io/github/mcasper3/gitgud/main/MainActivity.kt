package io.github.mcasper3.gitgud

import android.os.Bundle
import io.github.mcasper3.gitgud.base.GitGudActivity
import io.github.mcasper3.gitgud.repositories.RepositoryFragment
import io.github.mcasper3.gitgud.repositories.RepositoryRouter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : GitGudActivity() {

    @Inject internal lateinit var repositoryRouter: RepositoryRouter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO backstack listener to update the toolbar and animate fab
        savedInstanceState?.let {
            supportFragmentManager.beginTransaction()
                .replace(R.id.content, RepositoryFragment())
                .commit()
        }

        bottom_bar.setOnNavigationItemSelectedListener { true }
    }
}
