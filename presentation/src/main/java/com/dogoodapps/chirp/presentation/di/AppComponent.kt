package com.dogoodapps.chirp.presentation.di

import com.dogoodapps.chirp.presentation.ChirpApplication
import com.dogoodapps.data.di.DataModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [

        // Presentation
        AppModule::class,

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