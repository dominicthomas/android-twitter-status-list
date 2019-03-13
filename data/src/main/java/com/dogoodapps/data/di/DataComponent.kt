package com.dogoodapps.data.di

import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkingModule::class,
        RepositoryModule::class,
        UseCaseModule::class
    ]
)
interface DataComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun networkModule(networkingModule: NetworkingModule): Builder

        fun repositoryModule(repositoryModule: RepositoryModule): Builder

        fun useCaseModule(useCaseModule: UseCaseModule): Builder

        fun build(): DataComponent
    }
}