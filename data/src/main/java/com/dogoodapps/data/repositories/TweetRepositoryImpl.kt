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

    override fun getStatusList(token: String?, params: Map<String, String>): Single<List<Tweet>> {
        return tweetService.getStatusList(token, params)
    }
}