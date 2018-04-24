package io.github.mcasper3.gitgud.base

import android.content.Context
import android.support.v4.app.Fragment
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

open class BaseFragment : Fragment(), HasSupportFragmentInjector {

    @Inject internal lateinit var childFragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector() = childFragmentInjector

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
}
