package com.anangkur.adapterplayground.model

class Campaign(
    val id: Int,
    val banners: List<Banner>
): DelegateAdapterItem {
    override fun id(): Any {
        return id
    }

    override fun content(): Any {
        return banners
    }
}