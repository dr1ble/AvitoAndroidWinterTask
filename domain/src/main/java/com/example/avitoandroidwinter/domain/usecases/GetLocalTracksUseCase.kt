package com.example.avitoandroidwinter.domain.usecases

import com.example.avitoandroidwinter.domain.repository.TrackRepository

class GetLocalTracksUseCase(
    private val trackRepository: TrackRepository
) {
    operator fun invoke() = trackRepository.getLocalTracks()
}