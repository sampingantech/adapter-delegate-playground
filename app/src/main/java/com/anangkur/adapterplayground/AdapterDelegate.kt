package com.anangkur.adapterplayground

import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anangkur.adapterplayground.databinding.*
import com.anangkur.adapterplayground.model.*
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun bannerAdapterDelegate() = adapterDelegateViewBinding<Banner, DisplayableItem, ItemBannerBinding>(
    { layoutInflater, root -> ItemBannerBinding.inflate(layoutInflater, root, false) }
) {
    bind {
        binding.tvTitle.text = item.title
        binding.tvSubTitle.text = item.subTitle
        binding.tvDescription.text = item.description
    }
}

fun campaignAdapterDelegate() = adapterDelegateViewBinding<Campaign, DisplayableItem, ItemCampaignBinding>(
    { layoutInflater, root -> ItemCampaignBinding.inflate(layoutInflater, root, false) }
) {
    bind {
        val bannerAdapter = BannerAdapter()
        binding.recyclerBanner.apply {
            adapter = bannerAdapter
            itemAnimator = DefaultItemAnimator()
            layoutManager = LinearLayoutManager(itemView.context, RecyclerView.HORIZONTAL, false)
        }
        bannerAdapter.setItems(item.banners)
    }
}

fun featuredAdapterDelegate() = adapterDelegateViewBinding<Featured, DisplayableItem, ItemFeaturedBinding>(
    { layoutInflater, root -> ItemFeaturedBinding.inflate(layoutInflater, root, false) }
) {
    bind {
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

fun promotionAdapterDelegate() = adapterDelegateViewBinding<Promotion, DisplayableItem, ItemPromotionBinding>(
    { layoutInflater, root -> ItemPromotionBinding.inflate(layoutInflater, root, false) }
) {
    bind {
        val promoAdapter = PromoAdapter()
        binding.recyclerPromo.apply {
            adapter = promoAdapter
            itemAnimator = DefaultItemAnimator()
            layoutManager = LinearLayoutManager(itemView.context, RecyclerView.HORIZONTAL, false)
        }
        promoAdapter.setItems(item.promos)
        binding.tvTitle.text = item.title
        binding.tvAppName.text = item.app.name
        binding.tvAppDeveloper.text = item.app.developer
        binding.tvAppRating.text = item.app.size.toString()
    }
}