package com.example.avitoandroidwinter.data.model.responses

import com.google.gson.annotations.SerializedName

data class TracksDataResponse(
    @SerializedName("data") val data: List<TrackResponse>
)
