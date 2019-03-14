package com.dogoodapps.data.di

import dagger.Module

@Module(
    includes = [
        AuthModule::class,
        NetworkingModule::class,
        RepositoryModule::class,
        UseCaseModule::class
    ]
)
abstract class DataModule