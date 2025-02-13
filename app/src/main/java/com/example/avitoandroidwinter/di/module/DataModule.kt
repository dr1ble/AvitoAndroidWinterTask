package com.example.avitoandroidwinter.di.module

import com.example.avitoandroidwinter.data.network.Network
import com.example.avitoandroidwinter.data.repository.TrackRepositoryImpl
import com.example.avitoandroidwinter.data.services.DeezerApiService
import com.example.avitoandroidwinter.di.ApplicationScope
import com.example.avitoandroidwinter.domain.repository.TrackRepository
import com.google.gson.Gson
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module(includes = [DataModule.BindsModule::class])
class DataModule {
    @ApplicationScope
    @Provides
    fun provideDeezerApiService(): DeezerApiService {
        val retrofitInstance = Retrofit.Builder()
            .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor()).build())
            .baseUrl(Network.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
        return retrofitInstance.create()
    }

    @Module
    interface BindsModule {
        @ApplicationScope
        @Binds
        fun bindsTrackRepository(implTrackRepository: TrackRepositoryImpl): TrackRepository
    }
}