package com.anangkur.adapterplayground

import com.anangkur.adapterplayground.databinding.ItemBannerBinding
import com.anangkur.adapterplayground.databinding.ItemCampaignBinding
import com.anangkur.adapterplayground.databinding.ItemFeaturedBinding
import com.anangkur.adapterplayground.databinding.ItemPromotionBinding
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

    }
}

fun featuredAdapterDelegate() = adapterDelegateViewBinding<Featured, DisplayableItem, ItemFeaturedBinding>(
    { layoutInflater, root -> ItemFeaturedBinding.inflate(layoutInflater, root, false) }
) {
    bind {
        binding.tvTitle.text = item.title
        binding.tvSubTitle.text = item.subTitle
    }
}

fun promotionAdapterDelegate() = adapterDelegateViewBinding<Promotion, DisplayableItem, ItemPromotionBinding>(
    { layoutInflater, root -> ItemPromotionBinding.inflate(layoutInflater, root, false) }
) {
    bind {
        binding.tvTitle.text = item.title
        binding.tvAppName.text = item.app.name
        binding.tvAppDeveloper.text = item.app.developer
        binding.tvAppRating.text = item.app.size.toString()
    }
}