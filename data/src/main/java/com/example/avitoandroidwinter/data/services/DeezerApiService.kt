package com.example.avitoandroidwinter.data.services

import com.example.avitoandroidwinter.data.model.responses.DeezerResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DeezerApiService {
    @GET("chart")
    suspend fun getChartTracks(): Response<DeezerResponse>

    @GET("search")
    suspend fun searchTracks(@Query("q") query: String): Response<DeezerResponse>
}
