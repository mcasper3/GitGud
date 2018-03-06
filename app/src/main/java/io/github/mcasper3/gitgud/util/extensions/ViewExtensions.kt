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
