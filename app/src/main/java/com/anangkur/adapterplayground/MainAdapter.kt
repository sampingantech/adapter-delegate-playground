package com.anangkur.adapterplayground

import com.anangkur.adapterplayground.model.DisplayableItem
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class MainAdapter : ListDelegationAdapter<List<DisplayableItem>>(
    bannerAdapterDelegate(),
    campaignAdapterDelegate()
)