package com.example.avitoandroidwinter.di.module

import com.example.avitoandroidwinter.domain.repository.TrackRepository
import com.example.avitoandroidwinter.domain.usecases.GetChartTracksUseCase
import com.example.avitoandroidwinter.domain.usecases.GetSearchTracksUseCase
import com.example.avitoandroidwinter.domain.usecases.SearchTrackUseCase
import dagger.Module
import dagger.Provides


@Module
class DomainModule {
    @Provides
    fun providesGetSearchTracksUseCase(trackRepository: TrackRepository) = GetSearchTracksUseCase(trackRepository)

    @Provides
    fun providesSearchTrackUseCase(trackRepository: TrackRepository) = SearchTrackUseCase(trackRepository)

    @Provides
    fun providesGetChartTracksUseCase(trackRepository: TrackRepository) = GetChartTracksUseCase(trackRepository)
}