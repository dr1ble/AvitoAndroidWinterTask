package com.example.avitoandroidwinter.data.model.responses

import com.google.gson.annotations.SerializedName

data class Album(
    @SerializedName("id")
    val id: Long,

    @SerializedName("title")
    val title: String,

    @SerializedName("cover")
    val coverUrl: String,

)
