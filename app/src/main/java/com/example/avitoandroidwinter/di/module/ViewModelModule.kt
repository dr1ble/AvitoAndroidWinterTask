package com.example.avitoandroidwinter.di.module

import androidx.lifecycle.ViewModel
import com.example.avitoandroidwinter.ui.ViewModelKey
import com.example.avitoandroidwinter.ui.apitracks.ApiTracksViewModel
import com.example.avitoandroidwinter.ui.localtracks.LocalTracksViewModel
import com.example.avitoandroidwinter.ui.player.PlayerViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
@Suppress("UNUSED")
interface ViewModelModule {

    @IntoMap
    @Binds
    @ViewModelKey(LocalTracksViewModel::class)
    fun bindLocalTracksViewModel(viewModel: LocalTracksViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(ApiTracksViewModel::class)
    fun bindApiTracksViewModel(viewModel: ApiTracksViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(PlayerViewModel::class)
    fun bindPlayerViewModel(viewModel: PlayerViewModel): ViewModel

}