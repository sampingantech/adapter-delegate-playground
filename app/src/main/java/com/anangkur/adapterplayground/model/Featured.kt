package com.anangkur.adapterplayground.model

data class Featured(
    val title: String,
    val subTitle: String,
    val apps: List<App>
): DisplayableItem