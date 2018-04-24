package io.github.mcasper3.gitgud.util.extensions

import android.view.View
import android.view.ViewTreeObserver

fun View.afterInflate(body: () -> Unit) {
    class O : ViewTreeObserver.OnGlobalLayoutListener {
        override fun onGlobalLayout() {
            viewTreeObserver.removeOnGlobalLayoutListener(this)
            body()
        }
    }

    this.viewTreeObserver.addOnGlobalLayoutListener(O())
}

fun View.doOnPreDraw(body: () -> Unit) {
    viewTreeObserver.addOnPreDrawListener(
        object : ViewTreeObserver.OnPreDrawListener {
            override fun onPreDraw(): Boolean {
                viewTreeObserver.removeOnPreDrawListener(this)
                body()
                return true
            }
        })
}

fun View.showIf(shouldShow: Boolean) {
    visibility = if (shouldShow) View.VISIBLE else View.GONE
}

fun View.hideIf(shouldHide: Boolean) {
    visibility = if (shouldHide) View.GONE else View.VISIBLE
}
