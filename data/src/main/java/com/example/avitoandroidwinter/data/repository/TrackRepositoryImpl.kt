package com.example.avitoandroidwinter.data.repository

import android.util.Log
import com.example.avitoandroidwinter.data.mapper.TracksMapper
import com.example.avitoandroidwinter.data.services.DeezerApiService
import com.example.avitoandroidwinter.domain.model.Track
import com.example.avitoandroidwinter.domain.repository.TrackRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

class TrackRepositoryImpl @Inject constructor(
    private val apiService: DeezerApiService,
    private val mapper: TracksMapper
) : TrackRepository {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    init {
        Log.d("MEOW", "Init chart track")
        coroutineScope.launch {
            fetchChartTracks()
        }
    }

    private val _chartFlow: MutableStateFlow<List<Track>> = MutableStateFlow(emptyList())
    val chartFlow = _chartFlow.asStateFlow()

    private val _searchFlow: MutableStateFlow<List<Track>> = MutableStateFlow(emptyList())
    val searchFlow = _searchFlow.asStateFlow()

    private val _localFlow: MutableStateFlow<List<Track>> = MutableStateFlow(emptyList())
    val localFlow = _localFlow.asStateFlow()


    override fun getChartTracks(): Flow<List<Track>> {
        return chartFlow
    }

    override suspend fun searchTrack(query: String) = withContext(Dispatchers.IO) {
        Log.d("MEOW", "Searching for: $query")

        val responseBody = try {
            val response = apiService.searchTracks(query)
            if (!response.isSuccessful) {
                Log.e("MEOW", "API error: ${response.code()} ${response.message()}")
                null
            } else {
                response.body().also {
                    Log.d("MEOW", "API response: ${it?.data?.size} tracks")
                }
            }
        } catch (e: IOException) {
            Log.e("MEOW", "Network error: ${e.message}")
            null
        } catch (e: Exception) {
            Log.e("MEOW", "Unexpected error: ${e.javaClass.simpleName}", e)
            null
        }

        responseBody?.data?.let { data ->
            Log.d("MEOW", "Mapping ${data.size} tracks")
            val domainTracks = mapper.toDomainTracks(data)
            Log.d("MEOW", "Mapped ${domainTracks.size} domain tracks")
            withContext(Dispatchers.Main) { // Если flow используется в UI
                _searchFlow.value = domainTracks
            }
        }
        Unit
    }

    override fun getSearchTracks(): Flow<List<Track>> {
        return searchFlow
    }

    override fun getLocalTracks(): Flow<List<Track>> {
        return localFlow
    }

    private suspend fun fetchChartTracks() {
        Log.d("MEOW", "Searching for chart tracks")

        val responseBody = try {
            val response = apiService.getChartTracks()
            if (!response.isSuccessful) {
                Log.e("MEOW", "API error: ${response.code()} ${response.message()}")
                null
            } else {
                response.body().also {
                    Log.d("MEOW", "API response: ${it?.tracks?.data?.size} tracks")
                }
            }
        } catch (e: IOException) {
            Log.e("MEOW", "Network error: ${e.message}")
            null
        } catch (e: Exception) {
            Log.e("MEOW", "Unexpected error: ${e.javaClass.simpleName}", e)
            null
        }

        responseBody?.tracks?.data?.let { data ->
            Log.d("MEOW", "Mapping ${data.size} tracks")
            val domainTracks = mapper.toDomainTracks(data)
            Log.d("MEOW", "Mapped ${domainTracks.size} domain tracks")
            withContext(Dispatchers.Main) { // Если flow используется в UI
                _chartFlow.value = domainTracks
            }
        }
    }
}