package com.dogoodapps.data.repositories

import com.dogoodapps.data.networking.TweetService
import com.dogoodapps.domain.entities.Tweet
import com.dogoodapps.domain.repositories.TweetRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class TweetRepositoryImpl @Inject constructor(private val tweetService: TweetService) : TweetRepository {

    override fun getStatusList(): Single<List<Tweet>> {

        // TODO: Make configurable on call
        val queryParams = hashMapOf(
            "list_id" to "871746761387323394",
            "tweet_mode" to "extended",
            "include_entities" to 1,
            "count" to 10
        )

        return tweetService.getStatusList(queryParams)
    }
}