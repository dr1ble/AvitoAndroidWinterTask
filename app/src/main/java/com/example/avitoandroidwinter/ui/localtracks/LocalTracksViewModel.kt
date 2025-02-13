package com.example.avitoandroidwinter.ui.localtracks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class LocalTracksViewModel @Inject constructor() : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Local Tracks Fragment"
    }
    val text: LiveData<String> = _text
}