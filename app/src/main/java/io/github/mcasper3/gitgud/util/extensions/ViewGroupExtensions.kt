package io.github.mcasper3.gitgud.util.extensions

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.ViewGroup

fun ViewGroup.inflate(@LayoutRes layoutResId: Int) = LayoutInflater.from(context).inflate(layoutResId, this, false)
