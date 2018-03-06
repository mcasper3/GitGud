package io.github.mcasper3.gitgud.injection

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

@Module abstract class ApplicationModule {
    @Binds
    @AppContext
    abstract fun provideAppContext(app: Application): Context
}
