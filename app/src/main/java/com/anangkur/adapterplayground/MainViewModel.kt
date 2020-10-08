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
        displayableItems.add(Banner("Covid-19", "resources", "Useful apps & more", ""))
        displayableItems.add(Featured("Recenly updated", "Fresh features & content", emptyList()))
        displayableItems.add(Promotion("New to rent", App("Google Play Movies & TV", "Google LLC", "", 4.0f, 4, false), emptyList()))
        displayableItems.add(Campaign(listOf(
            Banner("Make stunning", "videos in seconds", "Explore templates", ""),
            Banner("Change colors", "in one tap", "Try AI Select", ""),
            Banner("Try new", "masking effects", "Make awesome videos", "")
        )))
        _displayedItems.postValue(displayableItems)
    }
}