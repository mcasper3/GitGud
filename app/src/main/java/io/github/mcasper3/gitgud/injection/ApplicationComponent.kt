package io.github.mcasper3.gitgud.injection

import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import io.github.mcasper3.gitgud.GitGudApplication
import io.github.mcasper3.gitgud.networking.NetworkingModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        AndroidSupportInjectionModule::class,
        ActivityBindingModule::class,
        NetworkingModule::class
    ]
)
interface ApplicationComponent {
    fun inject(app: GitGudApplication)
}
