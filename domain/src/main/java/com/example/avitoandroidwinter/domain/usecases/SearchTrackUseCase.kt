package com.example.avitoandroidwinter.domain.usecases

import com.example.avitoandroidwinter.domain.repository.TrackRepository

class SearchTrackUseCase(
    private val trackRepository: TrackRepository
) {
    suspend operator fun invoke(query: String) = trackRepository.searchTrack(query)
}