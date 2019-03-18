package com.dogoodapps.statuslist.presentation.di

import com.dogoodapps.statuslist.presentation.StatusListApplication
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
        fun application(application: StatusListApplication): Builder

        fun build(): AppComponent
    }

    fun inject(app: StatusListApplication)
}