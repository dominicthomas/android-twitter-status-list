package com.dogoodapps.chirp.presentation.di

import android.content.Context
import com.dogoodapps.chirp.presentation.ChirpApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideApplication(app: ChirpApplication): Context = app
}