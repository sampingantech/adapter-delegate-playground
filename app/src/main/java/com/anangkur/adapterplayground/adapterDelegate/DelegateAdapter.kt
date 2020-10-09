package com.anangkur.adapterplayground.adapterDelegate

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anangkur.adapterplayground.model.DelegateAdapterItem

abstract class DelegateAdapter<M, in VH : RecyclerView.ViewHolder>(val modelClass: Class<out M>) {

    abstract fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder
    abstract fun bindViewHolder(model: M, viewHolder: VH, payloads: List<DelegateAdapterItem.Payloadable>)

    open fun onViewRecycled(viewHolder: VH) = Unit
    open fun onViewDetachedFromWindow(viewHolder: VH) = Unit
    open fun onViewAttachedToWindow(viewHolder: VH) = Unit
}