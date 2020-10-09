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
        displayableItems.add(Featured("Recenly updated", "Fresh features & content", listOf(
            App("Podcast App: Free & Offline Podcasts by ...", "Podcast", "", 5.0f, 27, false),
            App("Air Brush: Easy Photo Editor", "Air Brush", "", 5.0f, 54, false),
            App("Soccer Scores - FotMob", "Soccer Scores", "", 5.0f, 14, false),
            App("Focus Plant - Stay Focused Study Timer", "Focus Plant", "", 5.0f, 50, false)
        )))
        _displayedItems.postValue(displayableItems)
    }
}