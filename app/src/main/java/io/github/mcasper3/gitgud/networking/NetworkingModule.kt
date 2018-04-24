package io.github.mcasper3.gitgud.networking

import android.content.Context
import android.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import io.github.mcasper3.gitgud.BuildConfig
import io.github.mcasper3.gitgud.injection.AppContext
import io.github.mcasper3.gitgud.login.SessionHelper
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module class NetworkingModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(@AppContext context: Context): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .addInterceptor {
                var builder = it.request().newBuilder()
                val token = PreferenceManager.getDefaultSharedPreferences(context).getString(SessionHelper.GITHUB_TOKEN_KEY, null)
                builder = if (!token.isNullOrEmpty()) {
                    builder.header("Authorization", "token $token")
                        .header("Accept", "application/vnd.github.v3+json")
                } else {
                    builder.header("Accept", "application/json")
                }
                it.proceed(builder.build())
            }

        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(interceptor)
        }

        return builder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient) = Retrofit.Builder()
        .baseUrl("https://api.github.com")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create())
        .client(client)
        .build()
}
