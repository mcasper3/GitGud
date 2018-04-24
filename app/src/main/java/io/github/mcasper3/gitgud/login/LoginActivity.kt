package io.github.mcasper3.gitgud.login

import android.content.Intent
import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.transition.ChangeBounds
import android.transition.Fade
import android.transition.TransitionManager
import android.transition.TransitionSet
import android.view.animation.AccelerateDecelerateInterpolator
import io.github.mcasper3.gitgud.R
import io.github.mcasper3.gitgud.base.GitGudActivity
import io.github.mcasper3.gitgud.util.extensions.doOnPreDraw
import io.github.mcasper3.prep.base.FailureUiModel
import io.github.mcasper3.prep.base.InProgressUiModel
import io.github.mcasper3.prep.base.SuccessUiModel
import io.github.mcasper3.prep.base.UiModel
import kotlinx.android.synthetic.main.activity_login_pre.*
import javax.inject.Inject

class LoginActivity : GitGudActivity() {

    @Inject internal lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme_Login)

        if (presenter.isLoggedIn()) {
            presenter.loginSucceeded()
        } else {
            if (savedInstanceState == null) {
                setContentView(R.layout.activity_login_pre)

                constraintLayout.doOnPreDraw {
                    animateLogo()
                }
            } else {
                setContentView(R.layout.activity_login)
                setUp()
            }
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)

        intent.data?.let {
            if ("gitgud" == it.scheme) {
                it.getQueryParameter("code")?.let {
                    presenter.onCodeObtained(it)
                        .subscribe { updateUi(it) }
                }
            }
        }
    }

    private fun updateUi(uiModel: UiModel) {
        when (uiModel) {
            is InProgressUiModel -> {
                // TODO show loading
            }
            is FailureUiModel -> {
                // TODO show error
            }
            is SuccessUiModel -> {
                presenter.loginSucceeded()
            }
        }
    }

    private fun animateLogo() {
        val transition = TransitionSet()
            .setOrdering(TransitionSet.ORDERING_TOGETHER)
            .addTransition(
                ChangeBounds()
                    .setDuration(450)
                    .setInterpolator(AccelerateDecelerateInterpolator())
                    .addTarget(logo)
            )
            .addTransition(
                Fade(Fade.IN)
                    .setDuration(300)
                    .setStartDelay(150)
                    .addTarget(loginButton)
            )

        val constraintSet = ConstraintSet()
        constraintSet.clone(this, R.layout.activity_login)

        TransitionManager.beginDelayedTransition(constraintLayout, transition)
        constraintSet.applyTo(constraintLayout)
        setUp()
    }

    private fun setUp() {
        loginButton.setOnClickListener { presenter.loginClicked() }
    }
}
