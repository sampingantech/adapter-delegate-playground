package com.anangkur.adapterplayground.adapterDelegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anangkur.adapterplayground.BannerAdapter
import com.anangkur.adapterplayground.DelegateAdapter
import com.anangkur.adapterplayground.databinding.ItemCampaignBinding
import com.anangkur.adapterplayground.model.Campaign
import com.anangkur.adapterplayground.model.DelegateAdapterItem

class CampaignAdapterDelegate: DelegateAdapter<Campaign, CampaignAdapterDelegate.CampaignViewHolder>(Campaign::class.java) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val binding = ItemCampaignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CampaignViewHolder(binding)
    }

    override fun bindViewHolder(
        model: Campaign,
        viewHolder: CampaignViewHolder,
        payloads: List<DelegateAdapterItem.Payloadable>
    ) {
        viewHolder.bind(model)
    }

    inner class CampaignViewHolder(private val binding: ItemCampaignBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Campaign) {
            val bannerAdapter = BannerAdapter()
            binding.recyclerBanner.apply {
                adapter = bannerAdapter
                itemAnimator = DefaultItemAnimator()
                layoutManager = LinearLayoutManager(itemView.context, RecyclerView.HORIZONTAL, false)
            }
            bannerAdapter.setItems(item.banners)
        }
    }
}