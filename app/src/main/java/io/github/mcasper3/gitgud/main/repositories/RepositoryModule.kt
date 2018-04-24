package io.github.mcasper3.gitgud.repositories

import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import retrofit2.Retrofit

@Module abstract class RepositoryModule {

    @ContributesAndroidInjector abstract fun repositoryFragment(): RepositoryFragment

    @Module
    companion object {
        @JvmStatic @Provides fun provideLoginService(retrofit: Retrofit) = retrofit.create(RepositoryService::class.java)
    }
}
