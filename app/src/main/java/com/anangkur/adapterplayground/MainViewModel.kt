package com.anangkur.adapterplayground

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anangkur.adapterplayground.model.*

class MainViewModel: ViewModel() {

    private val _displayedItems = MutableLiveData<List<DisplayableItem>>()
    val displayableItems: LiveData<List<DisplayableItem>> = _displayedItems

    fun createDummyDisplayableItems() {
        val displayableItems = ArrayList<DisplayableItem>()
        displayableItems.add(Promotion("New to rent", App("Google Play Movies & TV", "Google LLC", "", 4.0f, 4, false), listOf(
            "", "", "", "", "", "", "", "", "", ""
        )))
        displayableItems.add(Promotion("Top selling ebooks on Play", App("Google Play Books - Ebooks, Audio", "Google LLC", "", 4.1f, 4, false), listOf(
            "", "", "", "", "", "", "", "", "", ""
        )))
        _displayedItems.postValue(displayableItems)
    }
}