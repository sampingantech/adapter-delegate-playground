package com.anangkur.adapterplayground.adapterDelegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anangkur.adapterplayground.childAdapter.AppAdapter
import com.anangkur.adapterplayground.databinding.ItemFeaturedBinding
import com.anangkur.adapterplayground.model.DelegateAdapterItem
import com.anangkur.adapterplayground.model.Featured

class FeaturedAdapterDelegate: DelegateAdapter<Featured, FeaturedAdapterDelegate.FeaturedViewHolder>(Featured::class.java) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val binding = ItemFeaturedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FeaturedViewHolder(binding)
    }

    override fun bindViewHolder(
        model: Featured,
        viewHolder: FeaturedViewHolder,
        payloads: List<DelegateAdapterItem.Payloadable>
    ) {
        viewHolder.bind(model)
    }

    inner class FeaturedViewHolder(private val binding: ItemFeaturedBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Featured) {
            val appAdapter = AppAdapter()
            binding.recyclerApp.apply {
                adapter = appAdapter
                layoutManager = LinearLayoutManager(itemView.context, RecyclerView.HORIZONTAL, false)
                itemAnimator = DefaultItemAnimator()
            }
            appAdapter.setItems(item.apps)
            binding.tvTitle.text = item.title
            binding.tvSubTitle.text = item.subTitle
        }
    }
}