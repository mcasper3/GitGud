package io.github.mcasper3.gitgud.login

import android.content.Intent
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.transition.ChangeBounds
import android.transition.Fade
import android.transition.TransitionManager
import android.transition.TransitionSet
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.Button
import android.widget.ImageView
import io.github.mcasper3.gitgud.R
import io.github.mcasper3.gitgud.base.GitGudActivity
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class LoginActivity : GitGudActivity() {

    @Inject internal lateinit var presenter: LoginPresenter

    private val constraintLayout: ConstraintLayout by lazy { findViewById<ConstraintLayout>(R.id.constraint_layout) }
    private val logo: ImageView by lazy { findViewById<ImageView>(R.id.iv_logo) }
    private val loginButton: Button by lazy { findViewById<Button>(R.id.btn_login) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme_Login)

        if (savedInstanceState == null) {
            setContentView(R.layout.activity_login_pre)

            Observable.just(0)
                .delay(50, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    initializeAnimation()
                }
        } else {
            setContentView(R.layout.activity_login)
            setUp()
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)

        intent.data?.let {
            if ("gitgud" == it.scheme) {

                val test = it.getQueryParameter("code")
                Timber.i(test)
            }
        }
    }

    private fun initializeAnimation() {
        val transition = TransitionSet()
            .setOrdering(TransitionSet.ORDERING_SEQUENTIAL)
            .addTransition(
                ChangeBounds()
                    .setDuration(500)
                    .setInterpolator(AccelerateDecelerateInterpolator())
                    .addTarget(logo)
            )
            .addTransition(
                Fade(Fade.IN)
                    .setDuration(300)
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
