package com.dogoodapps.data.repositories

import com.dogoodapps.data.networking.TweetService
import com.dogoodapps.domain.entities.Tweet
import com.dogoodapps.domain.repositories.TweetRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class TweetRepositoryImpl @Inject constructor(
    private val tweetService: TweetService
) : TweetRepository {

    /**
     * Currently this repository just connects us to the api service but this repo could store data in memory or a
     * data store and return existing data if required (offline) or carry out a new request for fresh data.
     */
    override fun getTweets(token: String?, params: Map<String, String>): Single<List<Tweet>> {
        return tweetService.getStatusList(token, params)
    }
}