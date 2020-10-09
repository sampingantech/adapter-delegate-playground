package com.anangkur.adapterplayground.model

data class Featured(
    val title: String,
    val subTitle: String,
    val apps: List<App>
): DelegateAdapterItem {
    override fun id(): Any {
        return title
    }

    override fun content(): Any {
        return apps
    }
}