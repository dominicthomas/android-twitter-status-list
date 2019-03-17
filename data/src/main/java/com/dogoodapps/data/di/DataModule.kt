package com.dogoodapps.data.di

import dagger.Module

@Module(
    includes = [
        AuthModule::class,
        NetworkingModule::class,
        RepositoryModule::class,
        UseCaseModule::class,
        UtilsModule::class
    ]
)
abstract class DataModule