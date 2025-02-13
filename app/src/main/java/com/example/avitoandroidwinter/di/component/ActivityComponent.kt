package com.example.avitoandroidwinter.di.component

import com.example.avitoandroidwinter.MainActivity
import com.example.avitoandroidwinter.di.ApplicationScope
import com.example.avitoandroidwinter.di.module.DataModule
import com.example.avitoandroidwinter.di.module.DomainModule
import com.example.avitoandroidwinter.di.module.ViewModelModule
import com.example.avitoandroidwinter.ui.ViewModelFactory
import dagger.Component

@ApplicationScope
@Component(modules = [DataModule::class, ViewModelModule::class, DomainModule::class])
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)
    fun getViewModelFactory(): ViewModelFactory
}
