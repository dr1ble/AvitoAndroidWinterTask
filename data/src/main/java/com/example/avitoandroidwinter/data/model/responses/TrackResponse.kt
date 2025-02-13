package com.example.avitoandroidwinter.data.model.responses

import com.google.gson.annotations.SerializedName

data class TrackResponse(
    @SerializedName("id")
    val id: Long,

    @SerializedName("title")
    val title: String,

    @SerializedName("duration")
    val duration: Int,

    @SerializedName("preview")
    val previewUrl: String?,

    @SerializedName("artist")
    val artist: Artist,

    @SerializedName("album")
    val album: Album,

    ) {
}