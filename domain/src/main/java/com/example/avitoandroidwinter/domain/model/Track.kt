package com.example.avitoandroidwinter.domain.model

data class Track(
    val id: Long,
    val title: String,
    val artistName: String,
    val duration: String,
    val preview: String,
    val cover: String
)
