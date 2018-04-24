package io.github.mcasper3.gitgud

import android.app.Activity
import android.app.Application
import android.os.StrictMode
import com.squareup.leakcanary.LeakCanary
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.github.mcasper3.gitgud.injection.DaggerApplicationComponent
import io.github.mcasper3.gitgud.util.ProdTree
import timber.log.Timber
import javax.inject.Inject

class GitGudApplication : Application(), HasActivityInjector {

    @Inject internal lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityInjector
    }

    override fun onCreate() {
        super.onCreate()

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }

        LeakCanary.install(this)

        DaggerApplicationComponent.builder()
            .application(this)
            .build()
            .inject(this)

        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(
                StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .penaltyDialog()
                    .build()
            )
            StrictMode.setVmPolicy(
                StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build()
            )

            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(ProdTree())
        }
    }
}
