package io.github.mcasper3.gitgud.base.list

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import javax.inject.Inject

class RecyclerViewAdapter @Inject constructor() : RecyclerView.Adapter<BaseViewHolder<*>>() {

    private var viewHolderFactoryMap: MutableMap<Int, ViewHolderFactory<*>> = mutableMapOf()

    var viewHolderFactories: List<ViewHolderFactory<*>> = mutableListOf()
        set(value) {
            field = value
            viewHolderFactoryMap.clear()
            viewHolderFactoryMap.putAll(value.map { it.getViewType() to it })
            notifyDataSetChanged()
        }

    override fun getItemViewType(position: Int) = viewHolderFactories[position].getViewType()

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) = viewHolderFactories[position].bindViewHolder(holder)

    override fun getItemCount() = viewHolderFactories.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        viewHolderFactoryMap.getValue(viewType).createViewHolder(parent)

    fun getItems() = viewHolderFactories.map { it.item }

    operator fun plus(item: ViewHolderFactory<*>) {
        viewHolderFactoryMap.put(item.getViewType(), item)
        val updatedFactories = mutableListOf<ViewHolderFactory<*>>()
        updatedFactories.addAll(viewHolderFactories)
        updatedFactories.add(item)
        viewHolderFactories = updatedFactories
        notifyItemInserted(viewHolderFactories.size - 1)
    }
}
