package com.dogoodapps.data.di

import com.dogoodapps.data.repositories.TweetRepositoryImpl
import com.dogoodapps.domain.repositories.TweetRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton


@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    internal abstract fun bindTweetRepository(tweetRepository: TweetRepositoryImpl): TweetRepository
}