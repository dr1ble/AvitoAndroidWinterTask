package com.example.avitoandroidwinter.ui.apitracks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.avitoandroidwinter.domain.usecases.GetChartTracksUseCase
import com.example.avitoandroidwinter.domain.usecases.GetSearchTracksUseCase
import com.example.avitoandroidwinter.domain.usecases.SearchTrackUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class ApiTracksViewModel @Inject constructor(
    getSearchTracksUseCase: GetSearchTracksUseCase,
    getChartTracksUseCase: GetChartTracksUseCase,
    private val searchTracksUseCase: SearchTrackUseCase
) : ViewModel() {
    val searchTracksFlow = getSearchTracksUseCase()
    val chartTracksFlow = getChartTracksUseCase()

    fun searchQuery(query: String) {
        viewModelScope.launch {
            searchTracksUseCase(query)
        }
    }

    init {
        searchQuery("A")
    }
}