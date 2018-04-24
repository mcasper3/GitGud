package io.github.mcasper3.gitgud.base.list

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class BaseViewHolder<in T> constructor(item: View) : RecyclerView.ViewHolder(item) {
    abstract fun bind(item: T)
}
