package io.github.mcasper3.gitgud.login

import io.github.mcasper3.gitgud.BuildConfig
import io.github.mcasper3.gitgud.R
import io.github.mcasper3.gitgud.networking.ApiErrorTransformer
import io.github.mcasper3.prep.base.InProgressUiModel
import io.github.mcasper3.prep.base.SuccessUiModel
import io.github.mcasper3.prep.base.UiModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LoginPresenter @Inject constructor(
    private val loginService: LoginService,
    private val loginRouter: LoginRouter,
    private val sessionHelper: SessionHelper
) {

    internal fun isLoggedIn() = sessionHelper.isLoggedIn()

    internal fun loginClicked() {
        loginRouter.navigateToGithubSignin()
    }

    internal fun onCodeObtained(code: String) = loginService
        .logIn(LOGIN_URL, LoginRequest(BuildConfig.GITHUB_CLIENT_ID, BuildConfig.GITHUB_SECRET, code))
        .map {
            sessionHelper.token = it.accessToken
            SuccessUiModel() as UiModel
        }
        .startWith(InProgressUiModel())
        .compose(ApiErrorTransformer(errorMessageResId = R.string.failed_to_log_in))
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

    internal fun loginSucceeded() {
        loginRouter.navigateToMainPage()
    }

    companion object {
        private const val LOGIN_URL = "https://github.com/login/oauth/access_token"
    }
}
