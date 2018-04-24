package io.github.mcasper3.gitgud.login

import android.content.Context
import android.preference.PreferenceManager
import io.github.mcasper3.gitgud.injection.AppContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionHelper @Inject constructor(
    @AppContext context: Context
) {

    private val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    var token: String? = null
        get() {
            if (field == null) {
                field = sharedPreferences.getString(GITHUB_TOKEN_KEY, null)
            }
            return field
        }
        set(value) {
            field = value
            sharedPreferences.edit()
                .putString(GITHUB_TOKEN_KEY, value)
                .apply()
        }

    fun isLoggedIn() = token != null

    companion object {
        const val GITHUB_TOKEN_KEY = "GITHUB_TOKEN"
    }
}
