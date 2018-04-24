package io.github.mcasper3.gitgud.base.list

import android.support.annotation.DrawableRes
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.v7.widget.RecyclerView
import io.github.mcasper3.gitgud.R

class RecyclerViewConfiguration(
    val layoutManager: RecyclerView.LayoutManager,
    @StringRes val emptyStateTextResId: Int = INVALID_RES_ID,
    @DrawableRes val emptyStateImageResId: Int = INVALID_RES_ID,
    @StringRes val errorStateTextResId: Int = INVALID_RES_ID,
    @DrawableRes val errorStateImageResId: Int = INVALID_RES_ID,
    @LayoutRes val layoutResId: Int = R.layout.fragment_list
) {

    companion object {
        const val INVALID_RES_ID = 0
    }
}
