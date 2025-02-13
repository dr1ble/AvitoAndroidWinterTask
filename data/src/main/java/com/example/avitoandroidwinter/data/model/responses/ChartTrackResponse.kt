package com.example.avitoandroidwinter.data.model.responses

import com.google.gson.annotations.SerializedName

data class ChartTrackResponse(
    @SerializedName("tracks") val tracks: TracksDataResponse
)
