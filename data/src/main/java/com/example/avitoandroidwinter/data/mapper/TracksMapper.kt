package com.example.avitoandroidwinter.data.mapper

import com.example.avitoandroidwinter.data.model.responses.TrackResponse
import com.example.avitoandroidwinter.domain.model.Track
import com.example.avitoandroidwinter.domain.usecases.GetSearchTracksUseCase
import javax.inject.Inject

class TracksMapper @Inject constructor(
) {
    fun toDomainTrack(trackResponse: TrackResponse): Track {
        return Track(
            id = trackResponse.id.toString(),
            title = trackResponse.title,
            artist = trackResponse.artist.name,
            duration = trackResponse.duration,
            previewUrl = trackResponse.previewUrl,
            localPath = null,      // При маппинге из API локальный путь отсутствует
            coverUrl = trackResponse.album.coverUrl
        )
    }

    fun toDomainTracks(trackResponse: List<TrackResponse>): List<Track> {
        return trackResponse.map(::toDomainTrack)
    }
}


