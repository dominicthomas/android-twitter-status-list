package com.dogoodapps.chirp.presentation.di

import com.dogoodapps.chirp.presentation.ChirpApplication
import com.dogoodapps.chirp.presentation.ui.di.ViewModelModule
import com.dogoodapps.data.di.AuthModule
import com.dogoodapps.data.di.NetworkingModule
import com.dogoodapps.data.di.RepositoryModule
import com.dogoodapps.data.di.UseCaseModule

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
        NetworkingModule::class,
        RepositoryModule::class,
        UseCaseModule::class,
        AuthModule::class
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