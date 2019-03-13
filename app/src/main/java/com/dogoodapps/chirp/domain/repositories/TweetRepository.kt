package com.dogoodapps.chirp.domain.repositories

import com.dogoodapps.chirp.domain.entities.Tweet
import io.reactivex.Single

interface TweetRepository {
    fun getStatusList(token: String?, params: Map<String, String> ): Single<List<Tweet>>
}