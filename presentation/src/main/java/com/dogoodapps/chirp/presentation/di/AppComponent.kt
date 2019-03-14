package com.dogoodapps.chirp.presentation.di

import com.dogoodapps.chirp.presentation.ChirpApplication
import com.dogoodapps.chirp.presentation.ui.di.ViewModelModule
import com.dogoodapps.data.di.*

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [

        // Presentation
        AppModule::class,
        ActivityBuilder::class,
        FragmentBuilder::class,
        ViewModelModule::class,
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,

        // Data
        DataModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: ChirpApplication): Builder

        fun build(): AppComponent
    }

    fun inject(app: ChirpApplication)
}