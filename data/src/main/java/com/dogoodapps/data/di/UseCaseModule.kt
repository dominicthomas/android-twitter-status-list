package com.dogoodapps.data.di

import com.dogoodapps.data.usecases.GetTweetsUseCaseImpl
import com.dogoodapps.domain.repositories.TweetRepository
import com.dogoodapps.domain.usecases.GetTweetsUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Singleton
    @Provides
    fun provideTweetsUsecase(tweetRepository: TweetRepository): GetTweetsUseCase = GetTweetsUseCaseImpl(tweetRepository)
}