package io.github.mcasper3.gitgud.login

import android.net.Uri
import android.support.customtabs.CustomTabsIntent
import android.support.v4.content.ContextCompat
import io.github.mcasper3.gitgud.BuildConfig
import io.github.mcasper3.gitgud.R
import javax.inject.Inject

class LoginRouter @Inject constructor(private val activity: LoginActivity) {

    fun navigateToGithubSignin() {
        val uri = Uri.parse("https://github.com/login/oauth/authorize?client_id=${BuildConfig.GITHUB_CLIENT_ID}&scope=repo")

        val intent = CustomTabsIntent.Builder()
            .setToolbarColor(ContextCompat.getColor(activity, R.color.colorPrimaryDark))
            .setSecondaryToolbarColor(ContextCompat.getColor(activity, R.color.colorAccent))
            .build()

        intent.launchUrl(activity, uri)
    }
}
