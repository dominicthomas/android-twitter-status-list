package com.dogoodapps.data.di

import com.dogoodapps.data.usecases.GetTweetsUseCaseImpl
import com.dogoodapps.domain.usecases.GetTweetsUseCase
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class UseCaseModule {

    @Singleton
    @Binds
    internal abstract fun bindTweetsUseCase(getTweetsUseCase: GetTweetsUseCaseImpl): GetTweetsUseCase
}