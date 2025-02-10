package com.example.avitoandroidwinter.ui.apitracks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ApiTracksViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Api Tracks Fragment"
    }
    val text: LiveData<String> = _text
}