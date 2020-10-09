package com.anangkur.adapterplayground.model

data class Promotion(
    val title: String,
    val app: App,
    val promos: List<String>
): DelegateAdapterItem {
    override fun id(): Any {
        return title
    }

    override fun content(): Any {
        return promos
    }
}