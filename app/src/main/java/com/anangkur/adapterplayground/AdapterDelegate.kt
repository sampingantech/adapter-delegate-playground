package com.anangkur.adapterplayground

import com.anangkur.adapterplayground.databinding.ItemBannerBinding
import com.anangkur.adapterplayground.model.Banner
import com.anangkur.adapterplayground.model.DisplayableItem
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