package com.dogoodapps.domain.repositories

import com.dogoodapps.domain.entities.Tweet
import io.reactivex.Single

interface TweetRepository {
    fun getTweets(token: String?, params: Map<String, String>): Single<List<Tweet>>
}