package com.example.avitoandroidwinter.domain.repository

import com.example.avitoandroidwinter.domain.model.Track
import kotlinx.coroutines.flow.Flow


interface TrackRepository {
    fun getChartTracks(): Flow<List<Track>>
    suspend fun searchTrack(query: String)
    fun getSearchTracks(): Flow<List<Track>>
    fun getLocalTracks(): Flow<List<Track>>
}