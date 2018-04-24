package io.github.mcasper3.gitgud.networking

import android.support.annotation.StringRes
import io.github.mcasper3.prep.base.FailureUiModel
import io.github.mcasper3.prep.base.UiModel
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer

class ApiErrorTransformer(@StringRes private val errorMessageResId: Int) : ObservableTransformer<UiModel, UiModel> {

    override fun apply(upstream: Observable<UiModel>): ObservableSource<UiModel> {
        return upstream.onErrorReturn { FailureUiModel(errorMessageResId = errorMessageResId) }
    }
}
