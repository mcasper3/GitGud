package io.github.mcasper3.gitgud.base.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.mcasper3.gitgud.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject

open class ListFragment : BaseFragment() {

    @Inject lateinit var adapter: RecyclerViewAdapter

    open lateinit var configuration: RecyclerViewConfiguration

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(configuration.layoutResId, null)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager = configuration.layoutManager
        recyclerView.adapter = adapter
    }
}
