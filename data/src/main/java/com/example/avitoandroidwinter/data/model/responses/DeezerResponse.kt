package com.example.avitoandroidwinter.data.model.responses

import com.google.gson.annotations.SerializedName

data class DeezerResponse(
    @SerializedName("tracks") val tracks: TracksDataResponse
)
