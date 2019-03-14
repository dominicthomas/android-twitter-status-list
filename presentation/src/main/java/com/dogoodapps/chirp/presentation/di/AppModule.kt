package com.dogoodapps.chirp.presentation.di

import android.content.Context
import com.dogoodapps.chirp.presentation.ChirpApplication
import com.dogoodapps.chirp.presentation.ui.di.ViewModelModule
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
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class]
)
class AppModule {

    @Provides
    @Singleton
    fun provideApplication(app: ChirpApplication): Context = app
}