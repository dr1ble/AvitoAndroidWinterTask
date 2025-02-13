package com.example.avitoandroidwinter.domain.model

data class Track(
    val id: String,
    val title: String,
    val artist: String,
    val duration: Int, // в секундах
    val previewUrl: String?, // URL превью (для API)
    val localPath: String?, // путь к файлу (для локальных треков)
    val coverUrl: String? // URL обложки или путь к локальному изображению
)
