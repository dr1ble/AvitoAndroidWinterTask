package com.example.avitoandroidwinter.ui.basetracks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LocalTracksViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Local Tracks Fragment"
    }
    val text: LiveData<String> = _text
}