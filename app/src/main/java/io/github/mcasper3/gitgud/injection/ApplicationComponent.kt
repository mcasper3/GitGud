package io.github.mcasper3.gitgud.injection

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
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
interface ApplicationComponent : AndroidInjector<GitGudApplication> {
    override fun inject(app: GitGudApplication)

    @Component.Builder interface Builder {
        @BindsInstance fun application(application: Application): Builder
        fun build(): ApplicationComponent
    }
}
