package com.dogoodapps.chirp.data.di

import com.dogoodapps.chirp.data.repositories.TweetRepositoryImpl
import com.dogoodapps.chirp.domain.repositories.TweetRepository
import dagger.Binds
import dagger.Module


@Module
abstract class RepositoryModule {

    @Binds
    internal abstract fun bindTweetRepository(tweetRepository: TweetRepositoryImpl): TweetRepository
}