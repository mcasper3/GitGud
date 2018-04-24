package io.github.mcasper3.gitgud.login

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module abstract class LoginModule {

    @Module
    companion object {

        @JvmStatic @Provides fun provideLoginService(retrofit: Retrofit) = retrofit.create(LoginService::class.java)
    }
}
