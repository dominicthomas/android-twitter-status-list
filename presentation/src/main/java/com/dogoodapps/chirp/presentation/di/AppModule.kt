package com.dogoodapps.chirp.presentation.di

import android.content.Context
import com.dogoodapps.chirp.presentation.ChirpApplication
import com.dogoodapps.chirp.presentation.ui.di.ImageLoaderModule
import com.dogoodapps.chirp.presentation.ui.di.ViewModelModule
import com.dogoodapps.chirp.presentation.ui.main.di.FragmentBuilder
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Module(
    includes = [
        ActivityBuilder::class,
        FragmentBuilder::class,
        ViewModelModule::class,
        ImageLoaderModule::class,
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class
    ]
)
class AppModule {

    @Provides
    @Singleton
    fun provideApplication(app: ChirpApplication): Context = app
}