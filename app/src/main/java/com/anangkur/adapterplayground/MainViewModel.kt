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
        
        _displayedItems.postValue(displayableItems)
    }
}