package com.example.avitoandroidwinter.data.model.responses

import com.google.gson.annotations.SerializedName


data class TrackResponse(
    @SerializedName("id") val id: Long,
    @SerializedName("title") val title: String,
    @SerializedName("duration") val duration: Int,
    @SerializedName("preview") val preview: String,
    @SerializedName("artist") val artist: Artist,
    @SerializedName("album") val album: Album
)

data class Artist(
    @SerializedName("name") val name: String
)

data class Album(
    @SerializedName("cover_big") val coverBig: String
)
