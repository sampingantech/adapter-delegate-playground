package com.anangkur.adapterplayground.adapterDelegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anangkur.adapterplayground.DelegateAdapter
import com.anangkur.adapterplayground.databinding.ItemBannerBinding
import com.anangkur.adapterplayground.model.Banner
import com.anangkur.adapterplayground.model.DelegateAdapterItem

class BannerAdapterDelegate : DelegateAdapter<Banner, BannerAdapterDelegate.BannerViewHolder>(Banner::class.java) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val binding = ItemBannerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BannerViewHolder(binding)
    }

    override fun bindViewHolder(
        model: Banner,
        viewHolder: BannerViewHolder,
        payloads: List<DelegateAdapterItem.Payloadable>
    ) {
        viewHolder.bind(model)
    }

    inner class BannerViewHolder(private val binding: ItemBannerBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Banner) {
            binding.tvTitle.text = item.title
            binding.tvSubTitle.text = item.subTitle
            binding.tvDescription.text = item.description
        }
    }
}