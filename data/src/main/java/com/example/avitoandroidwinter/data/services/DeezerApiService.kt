package com.example.avitoandroidwinter.data.services

import com.example.avitoandroidwinter.data.model.responses.ChartTrackResponse
import com.example.avitoandroidwinter.data.model.responses.TracksDataResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DeezerApiService {
    @GET("chart")
    suspend fun getChartTracks(): Response<ChartTrackResponse>

    @GET("search")
    suspend fun searchTracks(@Query("q") query: String): Response<TracksDataResponse>
}
