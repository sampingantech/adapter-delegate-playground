package com.anangkur.adapterplayground.model

data class Promotion(
    val title: String,
    val app: App,
    val promos: List<String>
): DisplayableItem