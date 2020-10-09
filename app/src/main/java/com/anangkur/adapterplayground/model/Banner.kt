package com.anangkur.adapterplayground.model

data class Banner(
    val title: String,
    val subTitle: String,
    val description: String,
    val image: String
): DelegateAdapterItem {
    override fun id(): Any {
        return title
    }

    override fun content(): Any {
        return description
    }
}