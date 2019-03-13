package com.dogoodapps.data.di

import com.dogoodapps.data.usecases.GetTweetsUseCaseImpl
import com.dogoodapps.domain.usecases.GetTweetsUseCase
import dagger.Binds
import dagger.Module

@Module
abstract class UseCaseModule {

    @Binds
    internal abstract fun bindTweetsUseCase(getTweetsUseCase: GetTweetsUseCaseImpl): GetTweetsUseCase
}