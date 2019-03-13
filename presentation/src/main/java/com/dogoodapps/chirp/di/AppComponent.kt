package com.dogoodapps.chirp.di

import com.dogoodapps.chirp.ChirpApplication
import com.dogoodapps.chirp.ui.di.ViewModelModule
import com.dogoodapps.data.di.DataComponent
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        ActivityBuilder::class,
        FragmentBuilder::class,
        ViewModelModule::class,
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: ChirpApplication): Builder

        fun build(): AppComponent
    }

    fun dataComponent(): DataComponent

    fun inject(app: ChirpApplication)
}