package com.dogoodapps.data.di

import com.dogoodapps.data.networking.TweetService
import com.dogoodapps.data.repositories.TweetRepositoryImpl
import com.dogoodapps.domain.repositories.TweetRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideTweetRepository(tweetService: TweetService): TweetRepository = TweetRepositoryImpl(tweetService)
}