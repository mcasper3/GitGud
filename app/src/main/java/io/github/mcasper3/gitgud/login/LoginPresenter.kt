package io.github.mcasper3.gitgud.login

import javax.inject.Inject

class LoginPresenter @Inject constructor(
    private val loginService: LoginService,
    private val loginRouter: LoginRouter
) {

    fun loginClicked() {
        loginRouter.navigateToGithubSignin()
    }
}
