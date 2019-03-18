package com.dogoodapps.statuslist.presentation.di

import android.content.Context
import com.dogoodapps.statuslist.presentation.StatusListApplication
import com.dogoodapps.statuslist.presentation.ui.di.ImageLoaderModule
import com.dogoodapps.statuslist.presentation.ui.di.ViewModelModule
import com.dogoodapps.statuslist.presentation.ui.main.di.FragmentBuilder
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
    fun provideApplication(app: StatusListApplication): Context = app
}