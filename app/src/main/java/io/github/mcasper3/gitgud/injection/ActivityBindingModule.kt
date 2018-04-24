package io.github.mcasper3.gitgud.injection

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.github.mcasper3.gitgud.login.LoginActivity
import io.github.mcasper3.gitgud.login.LoginModule
import io.github.mcasper3.gitgud.main.MainActivity
import io.github.mcasper3.gitgud.main.repositories.RepositoryModule

@Module abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [LoginModule::class])
    abstract fun loginActivity(): LoginActivity

    @ContributesAndroidInjector(modules = [RepositoryModule::class])
    abstract fun mainActivity(): MainActivity
}
