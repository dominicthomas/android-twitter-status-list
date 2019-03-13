package com.dogoodapps.chirp.data.di

import com.dogoodapps.chirp.data.usecases.GetTweetsUseCaseImpl
import com.dogoodapps.chirp.domain.usecases.GetTweetsUseCase
import dagger.Binds
import dagger.Module

@Module
abstract class UseCaseModule {

    @Binds
    internal abstract fun bindTweetsUseCase(getTweetsUseCase: GetTweetsUseCaseImpl): GetTweetsUseCase
}